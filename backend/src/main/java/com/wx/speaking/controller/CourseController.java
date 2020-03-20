package com.wx.speaking.controller;

import com.wx.speaking.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CourseController {

    @Autowired
    CourseMapper courseMapper;

    @PostMapping("/addCourse")
    public void addCourse(HttpServletRequest request){
        String id = request.getParameter("id");
        Integer course_id = Integer.valueOf(request.getParameter("course_id"));


    }
}
