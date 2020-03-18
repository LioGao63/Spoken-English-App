package com.wx.speaking.controller;

import com.wx.speaking.bean.User;
import com.wx.speaking.mapper.UserMapper;
import com.wx.speaking.utils.HttpRequest ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.*;

@RestController
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @PostMapping( "/login")
    public void buttonTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code= request.getParameter("code");
        System.out.println(code);

        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wx0db9e901dad76940";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "8ddc10ae848ebcd1d165b3f0e3fbc644";
        // 授权（必填）
        String grant_type = "authorization_code";

        // 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        // 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
                + grant_type;
        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        // 解析相应内容（转换成json对象）

        JSONObject json = JSONObject.parseObject(sr);
        // 获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        // 用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        System.out.println(openid);


        System.out.println("code="+code);

        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write(openid);
        out.flush();

    }

    //通过id获取用户资料
    @GetMapping("/getUser/{id}")
    public User getUserInfo(@PathVariable("id") Integer id){
        User user = userMapper.getUserById(id);
        return user;
    }



}
