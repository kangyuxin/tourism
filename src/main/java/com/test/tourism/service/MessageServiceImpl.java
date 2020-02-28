package com.test.tourism.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.tourism.mapper.MessageMapper;
import com.test.tourism.model.Message;
import com.test.tourism.model.Scenery;
import com.test.tourism.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MessageServiceImpl {
    @Resource
    private MessageMapper messageMapper;

    public List<Message> findMessageById(String id) {
        return messageMapper.findMessageById(id);
    }

    public PageInfo<Message> findAllMessage(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Message> messageList = messageMapper.findAllMessage();
        PageInfo result = new PageInfo(messageList);
        return result;
    }

    public Message sendMessage(Message msg) {
        //表示留言成功

         //返回留言成功的那条数据的key
        int key = messageMapper.sendMessage(msg);
       // System.out.println(key);
            return  messageMapper.findById(msg.getMessageId());

    }

    public JSONObject deleteMessageById(String id){
        //i表示返回执行成功的条数
       int  i = messageMapper.deleteMessageById(id);
       //表示删除成功
        System.out.println(i);
        if(i!=0){

            return JsonResult.sendSuccess();
        }
        else{
            return JsonResult.sendError();
        }
    }
    //跟新一条留言
    public  int updateMessage(Message msg){
        return  messageMapper.updateMessage(msg);
    }

}
