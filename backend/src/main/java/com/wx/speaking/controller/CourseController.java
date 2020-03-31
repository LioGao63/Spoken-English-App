package com.wx.speaking.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.speaking.bean.Course;
import com.wx.speaking.bean.Sentence;
import com.wx.speaking.bean.Word;
import com.wx.speaking.mapper.CourseMapper;
import com.wx.speaking.mapper.SentenceMapper;
import com.wx.speaking.mapper.UserCourseMapper;
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

    @Autowired
    UserCourseMapper userCourseMapper;

    @PostMapping("/addCourse")
    public void addCourse(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        Integer course_id = Integer.valueOf(request.getParameter("course_id"));
        System.out.println(user_id + course_id);
        courseMapper.addUserCourse(user_id, course_id);
    }

    @GetMapping("/getCourseList")
    public List<Course> getAllCourse(HttpServletRequest request){
        JSONArray res = new JSONArray();
        List<Course> courseList = courseMapper.getAllCourse();
        return courseList;
    }

    @GetMapping("/getCourseById")
    public String getCourseById(HttpServletRequest request){
        JSONObject result = new JSONObject();
        String user_id = request.getParameter("user_id");
        Integer course_id = Integer.valueOf(request.getParameter("course_id"));
        Course course =  courseMapper.getCourseById(course_id);
        result.put("course_info", course);
        if (userCourseMapper.getCourseByUserAndCourseId(user_id, course_id)==null){
            result.put("is_chosen", 0);
            return result.toJSONString();
        }else{
            result.put("is_chosen", 1);
            return result.toJSONString();
        }

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

    @GetMapping("/getCourseByUserId")
    public List<Course> getCourseByUserId(HttpServletRequest request){
        String id = request.getParameter("user_id");
        return courseMapper.getCourseByUserId(id);
    }


}
