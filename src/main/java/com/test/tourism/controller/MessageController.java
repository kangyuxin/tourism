package com.test.tourism.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.test.tourism.model.Message;
import com.test.tourism.service.MessageServiceImpl;
import com.test.tourism.util.JsonResult;
import com.test.tourism.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MessageController {
    @Autowired
    private MessageServiceImpl messageServiceImpl;
    //根据游记id查询所有留言
    @RequestMapping("/findMessageById")
    public List<Message> findMessageById(String id){
        return  messageServiceImpl.findMessageById(id);
    }
    //发送一条留言
    @RequestMapping("/sendMessage")
    public Message sendMessage(Message msg){
        System.out.println(msg);
       return  messageServiceImpl.sendMessage(msg);
    }
    //删除一条留言根据message_id
    @RequestMapping("/deleteMessageById")
    public JSONObject deleteMessageById(String id){
        return messageServiceImpl.deleteMessageById(id);
    }
    //查询所有的留言
    @RequestMapping("/findAllMessage")
    public MessageVO findAll(@RequestParam(name = "page", required = false) int page,
                                @RequestParam(name = "limit", required = false) int limit) {
        PageInfo<Message> userPageInfo = messageServiceImpl.findAllMessage(page, limit);
        //获取数据的总条数
        int total = (int) userPageInfo.getTotal();
        /*设置总条数*/
        MessageVO messageVO = new MessageVO();
        messageVO.setCount(total);
        messageVO.setMessageList(userPageInfo.getList());
         return  messageVO;
    }
    @RequestMapping("/updateMessage")
    public  JSONObject updateMessage(Message msg){
        if (messageServiceImpl.updateMessage(msg) != 0) {
             return  JsonResult.sendSuccess();
        }else{
            return  JsonResult.sendError();
        }
    }
}
