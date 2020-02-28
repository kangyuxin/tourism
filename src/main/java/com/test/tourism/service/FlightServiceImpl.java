package com.test.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.tourism.mapper.FlightMapper;
import com.test.tourism.model.Flight;
import com.test.tourism.model.Scenery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightMapper {

    @Autowired
    private FlightMapper flightMapper;

    @Override
    public List<Flight> findAllFlight() {
        return flightMapper.findAllFlight();
    }

    @Override
    public Flight findFlightById(String id) {
        return flightMapper.findFlightById(id);
    }

    @Override
    public List<Flight> findFlightCityByName(String fromCity) {
        return flightMapper.findFlightCityByName(fromCity);
    }

    @Override
    public int deleteFlightById(String id) {
        return flightMapper.deleteFlightById(id);
    }

    @Override
    public int addFlight(Flight flight) {
        return flightMapper.addFlight(flight);
    }

    @Override
    public int updateFlight(Flight flight) {
        return flightMapper.updateFlight(flight);
    }
    public PageInfo<Flight> findAllFlight(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Flight> flightList = flightMapper.findAllFlight();
        PageInfo result = new PageInfo(flightList);
        return result;
    }
}
