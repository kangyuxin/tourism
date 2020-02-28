package com.test.tourism.mapper;

import com.test.tourism.model.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    //查询所有的留言根据游记id
    List<Message> findMessageById(String id);
    //发送一条留言到数据库中
    int sendMessage(Message msg);
    //根据id查询一条留言
    Message findById(Integer id);
    //根据id 删除一条留言
    int deleteMessageById(String id);
    //查询所有的留言
    List<Message> findAllMessage();
    //更新一条留言
    int updateMessage(Message msg);

}