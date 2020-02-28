package com.test.tourism.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.test.tourism.model.Hotel;
import com.test.tourism.model.Scenery;
import com.test.tourism.service.HotelServiceImpl;
import com.test.tourism.util.JsonResult;
import com.test.tourism.vo.HotelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class HotelController {
    @Autowired
    private HotelServiceImpl hotelService;

    @RequestMapping("/findHotelByType")
    public List<Hotel> findHotelByType(){
        return hotelService.findAllHotel();
    }

    @RequestMapping("/findHotelById")
    public Hotel findHotelById(String id){
        return hotelService.findHotelById(id);
    }

    @RequestMapping("/findHotelLocationById")
    public List<Hotel> findHotelLocationById(String id){
        return hotelService.findHotelLocationById(id);
    }

    @RequestMapping("/findAllHotel")
    public HotelVO findAllHotel(@RequestParam(name = "page", required = false) int page,
                                 @RequestParam(name = "limit", required = false) int limit) {
        PageInfo<Hotel> hotelPageInfo = hotelService.findAllHotel(page, limit);
        //获取数据的总条数
        int total = (int) hotelPageInfo.getTotal();
        /*设置总条数*/
        HotelVO hotelVO = new HotelVO();
        hotelVO.setCount(total);
        hotelVO.setHotelList(hotelPageInfo.getList());
        return hotelVO;
    }

    @RequestMapping("/deleteHotelById")
    public JSONObject deleteHotelById(String id){
        return JsonResult.sendError();
    }

    @RequestMapping("/updateHotel")
    public JSONObject updateHotel(Hotel hotel){
        System.out.println(hotel.toString());
        if(hotelService.updateHotel(hotel)!=0){
            return  JsonResult.sendSuccess();
        }
        else{
            return JsonResult.sendError();
        }
    }

    //酒店添加
    @RequestMapping("/addHotel")
    public JSONObject addHotel(Hotel hotel) {
        System.out.println(hotel);
        if(hotelService.addHotel(hotel)!=-1){
            return JsonResult.sendSuccess();
        }
        else{
            JSONObject json = new JSONObject();
            json.put("msg","未知错误");
            return json;
        }
    }

}
