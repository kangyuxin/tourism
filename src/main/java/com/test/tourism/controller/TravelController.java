package com.test.tourism.controller;

import com.test.tourism.model.Travel;
import com.test.tourism.service.TravelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TravelController {
    @Autowired
    private TravelServiceImpl travelService;
    @RequestMapping("findAllTravel")
    public List<Travel> findAllTravel(){
     return travelService.findAllTravel();
}

    @RequestMapping("findTravelById")
    public Travel findAllTravel(String id){
        return travelService.findTravelById(id);
    }
}
