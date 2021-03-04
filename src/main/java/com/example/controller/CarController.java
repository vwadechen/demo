package com.example.controller;

import com.example.pojo.Car;
import com.example.pojo.CarOrder;
import com.example.service.CarOrderService;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarOrderService carOrderService;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(@RequestBody CarOrder carOrder){
        Car car = carService.sel(carOrder.getCarType());
        if (null == car){
            return "抱歉该型号暂无可用车辆";
        }
        if (car.getIsUse() == 1){
            return "抱歉该型号暂无可用车辆";
        }
        //修改车辆状态
        Car car1 = new Car();
        car1.setCarType(car.getCarType());
        car1.setCarId(car.getCarId());
        car1.setIsUse(1);
        carService.updateStatus(car1);

        //添加订单
        carOrder.setCarId(car.getCarId());
        carOrderService.insertSelective(carOrder);
        return carOrderService.sel();
    }
}
