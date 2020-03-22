package com.wx.speaking.controller;

import com.wx.speaking.mapper.WordInfoMapper;
import com.wx.speaking.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @Autowired
    WordInfoMapper wordInfoMapper;

    @Autowired
    AsyncService asyncService;

    @PostMapping("testupdate")
    public String testReplace(HttpServletRequest request){
        String userId = request.getParameter("id");
        Integer wordId = Integer.valueOf(request.getParameter("word_id"));
        Double totalScore = Double.parseDouble(request.getParameter("total_score"));
        asyncService.updateWordInfo(userId, wordId, totalScore);
        return "成功";
    }
}
