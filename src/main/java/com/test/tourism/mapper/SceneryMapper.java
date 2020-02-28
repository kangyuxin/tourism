package com.test.tourism.mapper;

import com.test.tourism.model.Scenery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SceneryMapper {
    List<Scenery> findAllScenery();
    Scenery findById(String id);
    //根据城市名字搜索景点
    List<Scenery> findCityByName(String name);
    int deleteSceneryById(String id);
    int updateScenery(Scenery scenery);
    int addScenery(Scenery scenery);
}
