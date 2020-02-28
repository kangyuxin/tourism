package com.test.tourism.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.test.tourism.model.Scenery;
import com.test.tourism.model.User;
import com.test.tourism.service.SceneryServiceImpl;
import com.test.tourism.util.JsonResult;
import com.test.tourism.vo.SceneryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins="*")
@RestController
public class SceneryController {
    @Autowired
    private SceneryServiceImpl sceneryService;
    @RequestMapping("/findByType")
    public List<Scenery> findByType(){
        return sceneryService.findAllScenery();
    }

    @RequestMapping("/findById")
    public Scenery findByType(String  id){
        return sceneryService.findById(id);
    }

    @RequestMapping("/findCityByName")
    public List<Scenery> findCityByName(String  name){
        return sceneryService.findCityByName(name);
    }

    @RequestMapping("/findAll")
    public SceneryVO findAll(@RequestParam(name = "page", required = false) int page,
                             @RequestParam(name = "limit", required = false) int limit) {
        PageInfo<Scenery> sceneryPageInfo = sceneryService.findAll(page, limit);
        //获取数据的总条数
        int total = (int) sceneryPageInfo.getTotal();
        /*设置总条数*/
        SceneryVO sceneryVO = new SceneryVO();
        sceneryVO.setCount(total);
        sceneryVO.setSceneryList(sceneryPageInfo.getList());
        return sceneryVO;
    }

    //景点添加
    @RequestMapping("/addScenery")
    public JSONObject addScenery(Scenery scenery) {
        System.out.println(scenery);
            if(sceneryService.addScenery(scenery)!=-1){
                return JsonResult.sendSuccess();
            }
            else{
                JSONObject json = new JSONObject();
                json.put("msg","未知错误");
                return json;
            }
    }

    //删除景点通过id
    @RequestMapping("/deleteSceneryById")
    public JSONObject deleteSceneryById(String id){

//        if(sceneryService.deleteSceneryById(id)!=0){
//            return JsonResult.sendSuccess();
//        }else{
//            return JsonResult.sendError();
//        }
        return JsonResult.sendError();
}

    @RequestMapping("/updateScenery")
    public JSONObject updateScenery(Scenery scenery){
    System.out.println(scenery.toString());
        if(sceneryService.updateScenery(scenery)!=0){
            return JsonResult.sendSuccess();
        }
        else{
            return JsonResult.sendError();
        }
}

}
