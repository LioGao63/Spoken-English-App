package com.wx.speaking.controller;
import com.alibaba.fastjson.*;


public class ResultController {

    public static void resolveJson(String json){
        JSONObject dataOfJson; //评测数据

        //获取json最外层对象
        JSONObject jsonObject = JSONObject.parseObject(json);

        dataOfJson = jsonObject.getJSONObject("data");//获取数据对象



    }
}
