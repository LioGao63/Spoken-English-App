package com.wx.speaking.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.speaking.bean.Word;
import com.wx.speaking.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class WordController {

    @Autowired
    WordMapper wordMapper;


    @GetMapping("/getWord")
    public Word getWord(HttpServletRequest httpServletRequest){
        Integer id = Integer.valueOf(httpServletRequest.getParameter("id"));
        System.out.println("查单词");
        Word word = wordMapper.getWordById(id);
        return word;
    }

    @GetMapping("/getAllWord")
    public List<Word> getAllWord(){
        return wordMapper.getAllWord();
    }

    @PostMapping("/updateWord")
    public void updateWord(Word word){
        wordMapper.updateWord(word);
    }
}
