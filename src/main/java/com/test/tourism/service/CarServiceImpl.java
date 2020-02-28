package com.test.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.tourism.mapper.CarMapper;
import com.test.tourism.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarMapper {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> findAllCar() {
        return carMapper.findAllCar();
    }

    @Override
    public Car findCarById(String id) {
        return carMapper.findCarById(id);
    }

    @Override
    public List<Car> findCarLocationById(String id) {
        return carMapper.findCarLocationById(id);
    }

    @Override
    public int deleteCarById(String id) {
        return carMapper.deleteCarById(id);
    }

    @Override
    public int addCar(Car car) {
        return carMapper.addCar(car);
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateCar(car);
    }
    public PageInfo<Car> findAllCar(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Car> carList = carMapper.findAllCar();
        PageInfo result = new PageInfo(carList);
        return result;
    }
}
