package com.wx.speaking.mapper;

import com.wx.speaking.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    public void addUserCourse(String user_id, Integer course_id);

    public Course getCourseById(Integer id);

    public List<Course> getAllCourse();

    public List<Course> getCourseByUserId(String user_id);
}
