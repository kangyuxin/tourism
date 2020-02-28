package com.test.tourism.mapper;

import com.test.tourism.model.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> findAllCar();
    Car findCarById(String id);

    List<Car> findCarLocationById(String id);
    int deleteCarById(String id);
    int updateCar(Car car);

    int addCar(Car car);
}
