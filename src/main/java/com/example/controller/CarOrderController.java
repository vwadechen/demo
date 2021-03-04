package com.example.controller;

import com.example.mapper.CarMapper;
import com.example.mapper.CarOrderMapper;
import com.example.pojo.Car;
import com.example.pojo.CarOrder;
import com.example.service.CarOrderService;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/car/order")
public class CarOrderController {

    @Autowired
    private CarOrderService carOrderService;

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/getOrderList",method = RequestMethod.GET)
    public Object getOrderList(@RequestParam Integer id){
        return carOrderService.getOrderList(id);
    }

    @RequestMapping(value = "/returnOrder",method = RequestMethod.POST)
    public Object returnOrder(@RequestBody CarOrder carOrder){
        //修改归还时间
        carOrderService.updateByPrimaryKeySelective(carOrder);

        CarOrder order = carOrderService.selectByPrimaryKey(carOrder.getSuriNum());

        Car car2 = new Car();
        car2.setCarId(order.getCarId());
        car2.setCarType(order.getCarType());
        car2.setIsUse(0);
        carService.updateStatus(car2);

        Car car = new Car();
        car.setCarId(order.getCarId());
        car.setCarType(order.getCarType());
        Car car1 = carService.sel1(car);

        // 获取相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getRentDay());
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(order.getReturnDay());
        long timeInMillis2 = calendar.getTimeInMillis();
        long betweenDays =  (timeInMillis2 - timeInMillis1) / (1000L*3600L*24L) > 0 ? (timeInMillis2 - timeInMillis1) / (1000L*3600L*24L) :1;

        BigDecimal money = new BigDecimal(car1.getRentMoney().toString()).multiply(new BigDecimal(betweenDays)).setScale(2);

        Map map = new HashMap();
        map.put("订单编号",carOrder.getSuriNum());
        map.put("总金额",money);
        return map;
    }
}
