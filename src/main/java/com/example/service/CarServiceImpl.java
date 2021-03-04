package com.example.service;

import com.example.mapper.CarMapper;
import com.example.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarMapper carMapper;
    @Override
    public Car sel(String code) {
        return carMapper.sel(code);
    }

    @Override
    public void updateStatus(Car car) {
        carMapper.updateStatus(car);
    }

    @Override
    public Car sel1(Car car) {
        return carMapper.sel1(car);
    }
}
