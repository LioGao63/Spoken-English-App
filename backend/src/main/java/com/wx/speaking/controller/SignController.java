package com.wx.speaking.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.speaking.bean.Sign;
import com.wx.speaking.mapper.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class SignController {

    @Autowired
    SignMapper signMapper;

    @PostMapping("/sign")
        public String signIn(HttpServletRequest request){
        JSONObject result = new JSONObject();
        String user_id = request.getParameter("user_id");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String now_date = format.format(date);
        signMapper.updateSign(user_id, now_date);
        Sign sign = signMapper.getSignById(user_id);
        result.put("sign", sign);
        return result.toJSONString();
    }
}
