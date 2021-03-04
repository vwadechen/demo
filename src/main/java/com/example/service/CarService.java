package com.example.service;

import com.example.pojo.Car;

public interface CarService {

    Car sel(String code);

    void updateStatus(Car car);

    Car sel1(Car car);

}
