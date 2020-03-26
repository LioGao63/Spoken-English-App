package com.wx.speaking.controller;

import com.alibaba.fastjson.JSONArray;
import com.wx.speaking.bean.Course;
import com.wx.speaking.bean.Sentence;
import com.wx.speaking.bean.Word;
import com.wx.speaking.mapper.CourseMapper;
import com.wx.speaking.mapper.SentenceMapper;
import com.wx.speaking.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    WordMapper wordMapper;

    @Autowired
    SentenceMapper sentenceMapper;

    @PostMapping("/addCourse")
    public void addCourse(Course course){
        courseMapper.addUserCourse(course);
    }

    @GetMapping("getCourseList")
    public List<Course> getAllCourse(HttpServletRequest request){
        JSONArray res = new JSONArray();
        List<Course> courseList = courseMapper.getAllCourse();
        return courseList;
    }

    @GetMapping("/getWordList")
    public List<Word> getWordListById(HttpServletRequest request){
        Integer course_id = Integer.valueOf(request.getParameter("course_id"));
        List<Word> wordList = wordMapper.getWordList(course_id);
        return wordList;
    }

    @GetMapping("/getSentenceList")
    public List<Sentence> getSentenceListById(HttpServletRequest request){
        Integer course_id = Integer.valueOf(request.getParameter("course_id"));
        List<Sentence> sentenceList = sentenceMapper.getSentenceList(course_id);
        return sentenceList;
    }


}
