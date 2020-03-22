package com.wx.speaking.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.speaking.bean.WordInfo;
import com.wx.speaking.mapper.SentenceInfoMapper;
import com.wx.speaking.mapper.SentenceMapper;
import com.wx.speaking.mapper.WordInfoMapper;
import com.wx.speaking.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PractiseController {

    @Autowired
    WordMapper wordMapper;

    @Autowired
    SentenceMapper sentenceMapper;

    @Autowired
    SentenceInfoMapper sentenceInfoMapper;

    @Autowired
    WordInfoMapper wordInfoMapper;

    @GetMapping("/practise")
    public String practise(HttpServletRequest request){
        JSONObject result = new JSONObject();
        String openid = request.getParameter("id");
        Integer content_id = Integer.valueOf(request.getParameter("content_id"));
        Integer type = Integer.valueOf(request.getParameter("type"));

        if(type==0){
            result.put("total", wordMapper.getWordById(content_id));
            WordInfo wordInfo = wordInfoMapper.getWordInfo(openid, content_id);
            result.put("avg", wordInfo.getTotalScore());
            return result.toJSONString();
        }else{
            result.put("total", sentenceMapper.getSentenceById(content_id));
            result.put("avg", sentenceInfoMapper.getSentenceInfo(openid, content_id));
            return result.toJSONString();
        }


    }
}
