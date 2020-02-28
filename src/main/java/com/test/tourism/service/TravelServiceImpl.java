package com.test.tourism.service;

import com.test.tourism.mapper.TravelMapper;
import com.test.tourism.model.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TravelServiceImpl implements TravelMapper {
    @Autowired
    private TravelMapper travelMapper;
    @Override
    public List<Travel> findAllTravel() {
        return travelMapper.findAllTravel();
    }

    @Override
    public Travel findTravelById(String id) {
        return travelMapper.findTravelById(id);
    }

}
