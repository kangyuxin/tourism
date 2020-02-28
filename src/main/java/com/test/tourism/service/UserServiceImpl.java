package com.test.tourism.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.tourism.mapper.UserMapper;
import com.test.tourism.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserMapper{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);

    }

    @Override
    public User isRegister(String name) {
        return userMapper.isRegister(name);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);

    }

    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    public PageInfo<User> findAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findAllUser();
        PageInfo result = new PageInfo(userList);
        return result;
    }


    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
