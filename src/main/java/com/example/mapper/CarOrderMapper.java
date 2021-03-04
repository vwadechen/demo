package com.example.mapper;

import com.example.pojo.CarOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CarOrderMapper {
    int deleteByPrimaryKey(Integer suriNum);

    int insert(CarOrder record);

    int insertSelective(CarOrder record);

    CarOrder selectByPrimaryKey(Integer suriNum);

    int updateByPrimaryKeySelective(CarOrder record);

    int updateByPrimaryKey(CarOrder record);

    Map sel();

    List<Map> getOrderList(@Param("id") Integer id);
}