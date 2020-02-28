package com.test.tourism.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.test.tourism.model.Car;
import com.test.tourism.model.Scenery;
import com.test.tourism.service.CarServiceImpl;
import com.test.tourism.util.JsonResult;
import com.test.tourism.vo.CarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    @RequestMapping("/findCarByType")
    public List<Car> findFlightByType(){
        return carService.findAllCar();
    }

    @RequestMapping("/findCarById")
    public Car findFlightById(String id){
        return carService.findCarById(id);
    }

    @RequestMapping("/findCarLocationById")
    public List<Car> findCarLocationById(String id){
        return carService.findCarLocationById(id);
    }

    @RequestMapping("/findAllCar")
    public CarVO findAllCar(@RequestParam(name = "page", required = false) int page,
                               @RequestParam(name = "limit", required = false) int limit) {
        PageInfo<Car> carPageInfo = carService.findAllCar(page, limit);
        //获取数据的总条数
        int total = (int) carPageInfo.getTotal();
        /*设置总条数*/
        CarVO carVO = new CarVO();
        carVO.setCount(total);
        carVO.setCarList(carPageInfo.getList());
        return carVO;
    }

    //出租车添加
    @RequestMapping("/addCar")
    public JSONObject addCar(Car car) {
        System.out.println(car);
        if(carService.addCar(car)!=-1){
            return JsonResult.sendSuccess();
        }
        else{
            JSONObject json = new JSONObject();
            json.put("msg","未知错误");
            return json;
        }
    }

    @RequestMapping("/deleteCarById")
    public JSONObject deleteCarById(String id){
        return JsonResult.sendError();
    }

    @RequestMapping("/updateCar")
    public JSONObject updateCar(Car car){
        System.out.println(car.toString());
        if(carService.updateCar(car)!=0){
            return JsonResult.sendSuccess();
        }
        else{
            return JsonResult.sendError();
        }
    }
}
