package com.test.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.tourism.mapper.HotelMapper;
import com.test.tourism.model.Hotel;
import com.test.tourism.model.Scenery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelMapper {

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public List<Hotel> findAllHotel() {
        return hotelMapper.findAllHotel();
    }

    @Override
    public int addHotel(Hotel hotel) {
        return hotelMapper.addHotel(hotel);
    }

    @Override
    public Hotel findHotelById(String id) {
        return hotelMapper.findHotelById(id);
    }

    @Override
    public List<Hotel> findHotelLocationById(String id) {
        return hotelMapper.findHotelLocationById(id);
    }

    @Override
    public int deleteHotelById(String id) {
        return hotelMapper.deleteHotelById(id);
    }

    @Override
    public int updateHotel(Hotel hotel) {
        return hotelMapper.updateHotel(hotel);
    }

    public PageInfo<Hotel> findAllHotel(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Hotel> hotelList = hotelMapper.findAllHotel();
        PageInfo result = new PageInfo(hotelList);
        return result;
    }
}
