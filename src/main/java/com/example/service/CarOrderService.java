package com.example.service;

import com.example.pojo.CarOrder;

import java.util.List;
import java.util.Map;

public interface CarOrderService {

    int insertSelective(CarOrder record);

    Map sel();

    List<Map> getOrderList(Integer id);

    int updateByPrimaryKeySelective(CarOrder record);

    CarOrder selectByPrimaryKey(Integer suriNum);
}
