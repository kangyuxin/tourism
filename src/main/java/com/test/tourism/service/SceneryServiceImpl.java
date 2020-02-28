package com.test.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.tourism.mapper.SceneryMapper;
import com.test.tourism.model.Scenery;
import com.test.tourism.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneryServiceImpl implements SceneryMapper {
    @Autowired
    private SceneryMapper sceneryMapper;
    @Override
    public List<Scenery> findAllScenery() {
        return sceneryMapper.findAllScenery();
    }

    @Override
    public Scenery findById(String id) {
        return sceneryMapper.findById(id);
    }

    @Override
    public List<Scenery> findCityByName(String name) {
        return sceneryMapper.findCityByName(name);
    }

    //根据id删除景点
    @Override
    public int deleteSceneryById(String id) {
        return  sceneryMapper.deleteSceneryById(id);
    }

    @Override
    public int addScenery(Scenery scenery) {
        return sceneryMapper.addScenery(scenery);
    }

    @Override
    public int updateScenery(Scenery scenery) {

        return sceneryMapper.updateScenery(scenery);
    }

    public PageInfo<Scenery> findAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Scenery> sceneryList = sceneryMapper.findAllScenery();
        PageInfo result = new PageInfo(sceneryList);
        return result;
    }
}


