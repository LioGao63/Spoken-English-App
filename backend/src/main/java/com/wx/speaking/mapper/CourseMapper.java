package com.wx.speaking.mapper;

import com.wx.speaking.bean.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {

    public void addUserCourse(Course course);

    public Course getCourseByUserId(Integer id);
}
