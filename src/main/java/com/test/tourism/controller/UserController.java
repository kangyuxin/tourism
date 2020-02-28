package com.test.tourism.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.test.tourism.model.User;
import com.test.tourism.service.UserServiceImpl;
import com.test.tourism.util.JsonResult;
import com.test.tourism.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //用户退出
    @RequestMapping("/exit")
    public JSONObject exit(HttpServletRequest request){
        request.getSession().invalidate();
        //System.out.println(request.getSession().getId());
        return  JsonResult.sendSuccess();
    }


//用户登录
    @RequestMapping("/login")
    public JSONObject login(User user, HttpServletRequest request, HttpServletResponse response) {

        if(user.getUserType()==null){
           //默认为普通用户
            user.setUserType("user");
        }
        if (userService.login(user) != null) {
           // System.out.println("登录成功！");
            HttpSession session = request.getSession();
           //设置会话session对象有效期，默认10分钟
            session.setMaxInactiveInterval(10*60);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(10*60);
            response.addCookie(cookie);
            System.out.println(cookie.toString());
            session.setAttribute("username",user.getUserName());
            return JsonResult.sendSuccess();
        } else {
            return JsonResult.sendError();
        }
    }
    //用户注册
    @RequestMapping("/register")
    public JSONObject register(User user) {
        //user.setUserType("user");
        System.out.println(user);
        //注册之前先判断用户是否已经注册,如果为null,则表明用户没有注册
       if(userService.isRegister(user.getUserName())==null){
           //表明注册成功
           if(userService.register(user)!=-1){
               return JsonResult.sendSuccess();
           }
           else{
               JSONObject json = new JSONObject();
               json.put("msg","未知错误");
               return  json;
           }

       }else{
           //告知用户已经注册过了
           return JsonResult.sendError();
       }
    }
    @RequestMapping("/findAllUser")
    public ResultVO findAll(@RequestParam(name = "page", required = false) int page){
        PageInfo<User> userPageInfo = userService.findAll(page,10);
        //获取数据的总条数
        int total=(int)userPageInfo.getTotal();
        /*设置总条数*/
        ResultVO resultVO =  new ResultVO();
        resultVO.setCount(total);
        List<User> list=new ArrayList<>();
        for(User user:userPageInfo.getList() ){
            if(user.getUserType().equals("user")){
                user.setUserType("普通游客");
            }
            list.add(user);
        }
        System.out.println(list);
        resultVO.setUserList(list);
        return resultVO;
    }
    //根据id删除
    @RequestMapping("/deleteById")
    public JSONObject deleteById(String id){
        if(userService.deleteById(id)!=0){
            return  JsonResult.sendSuccess();
        }
        else {
            return  JsonResult.sendError();
        }
    }

    @RequestMapping("/updateById")
    public JSONObject updateById(User user){
        if(userService.updateById(user)!=0){
            return  JsonResult.sendSuccess();
        }
        else {
            return JsonResult.sendError();
        }
    }
}
