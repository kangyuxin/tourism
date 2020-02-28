package com.test.tourism.mapper;

import com.test.tourism.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //登录
    public abstract User login(User user);

    User isRegister(String name);

    int register(User user);

    //查询所有用户
    List<User>  findAllUser();
  //删除通过id
    int deleteById(String id);

    int updateById(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}