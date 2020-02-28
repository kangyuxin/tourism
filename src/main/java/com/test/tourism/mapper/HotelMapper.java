package com.test.tourism.mapper;


import com.test.tourism.model.Hotel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelMapper {
    List<Hotel> findAllHotel();
    Hotel findHotelById(String id);

    List<Hotel> findHotelLocationById(String id);
    int deleteHotelById(String id);
    int updateHotel(Hotel hotel);

    int addHotel(Hotel hotel);
}
