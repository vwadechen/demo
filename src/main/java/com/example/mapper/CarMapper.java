package com.example.mapper;

import com.example.pojo.Car;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CarMapper {
    int insert(Car record);

    int insertSelective(Car record);

    Car sel(@Param("code") String code);

    int updateStatus(Car record);

    Car sel1(Car car);
}