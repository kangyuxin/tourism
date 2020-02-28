package com.test.tourism.mapper;

import com.test.tourism.model.Travel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelMapper {
    List<Travel> findAllTravel();
    Travel findTravelById(String id);
}