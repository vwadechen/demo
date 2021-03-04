package com.example.service;

import com.example.mapper.CarOrderMapper;
import com.example.pojo.CarOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarOrderServiceImpl implements CarOrderService{

    @Autowired
    private CarOrderMapper carOrderMapper;
    @Override
    public int insertSelective(CarOrder record) {
        return carOrderMapper.insertSelective(record);
    }

    @Override
    public Map sel() {
        return carOrderMapper.sel();
    }

    @Override
    public List<Map> getOrderList(Integer id) {
        return carOrderMapper.getOrderList(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CarOrder record) {
        return carOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public CarOrder selectByPrimaryKey(Integer suriNum) {
        return carOrderMapper.selectByPrimaryKey(suriNum);
    }
}
