package com.example.service;

import com.example.pojo.Car;
import org.apache.ibatis.annotations.Param;

public interface CarService {

    Car sel(String code);

    int updateStatus(Car car);

    Car sel1(Car car);

}
