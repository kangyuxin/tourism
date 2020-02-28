package com.test.tourism.mapper;

import com.test.tourism.model.Flight;
import com.test.tourism.model.Scenery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlightMapper {
    List<Flight> findAllFlight();
    Flight findFlightById(String id);

    List<Flight> findFlightCityByName(String fromCity);
    int deleteFlightById(String id);
    int updateFlight(Flight flight);

    int addFlight(Flight flight);

}
