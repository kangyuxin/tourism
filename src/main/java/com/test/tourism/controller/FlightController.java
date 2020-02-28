package com.test.tourism.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.test.tourism.model.Flight;
import com.test.tourism.model.Scenery;
import com.test.tourism.service.FlightServiceImpl;
import com.test.tourism.util.JsonResult;
import com.test.tourism.vo.FlightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @RequestMapping("/findFlightByType")
    public List<Flight> findFlightByType(){
        return flightService.findAllFlight();
    }

    @RequestMapping("/findFlightById")
    public Flight findFlightById(String id){
        return flightService.findFlightById(id);
    }

    @RequestMapping("/findFlightCityByName")
    public List<Flight> findFlightCityByName(String fromCity){
        return flightService.findFlightCityByName(fromCity);
    }

    @RequestMapping("/findAllFlight")
    public FlightVO findAllFlight(@RequestParam(name = "page", required = false) int page,
                            @RequestParam(name = "limit", required = false) int limit) {
        PageInfo<Flight> flightPageInfo = flightService.findAllFlight(page, limit);
        //获取数据的总条数
        int total = (int) flightPageInfo.getTotal();
        /*设置总条数*/
        FlightVO flightVO = new FlightVO();
        flightVO.setCount(total);
        flightVO.setFlightList(flightPageInfo.getList());
        return  flightVO;
    }

    //航班添加
    @RequestMapping("/addFlight")
    public JSONObject addFlight(Flight flight) {
        System.out.println(flight);
        if(flightService.addFlight(flight)!=-1){
            return JsonResult.sendSuccess();
        }
        else{
            JSONObject json = new JSONObject();
            json.put("msg","未知错误");
            return json;
        }
    }

    //删除景点通过id
    @RequestMapping("/deleteFlightById")
    public JSONObject deleteFlightById(String id){
        return JsonResult.sendError();
    }

    @RequestMapping("/updateFlight")
    public JSONObject updateFlight(Flight flight){
        System.out.println(flight.toString());
        if(flightService.updateFlight(flight)!=0){
            return  JsonResult.sendSuccess();
        }
        else{
            return JsonResult.sendError();
        }
    }

}
