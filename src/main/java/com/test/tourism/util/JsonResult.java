package com.test.tourism.util;

import com.alibaba.fastjson.JSONObject;

public class JsonResult {
    public static JSONObject sendSuccess(){

        JSONObject json = new JSONObject();
        json.put("msg","success");
        return json;
    }
    public static JSONObject sendError(){

        JSONObject json = new JSONObject();
        json.put("msg","error");
        return json;
    }
}
