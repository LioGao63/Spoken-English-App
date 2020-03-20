package com.wx.speaking.mapper;

import com.wx.speaking.bean.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {

    public void addUserCourse(String id, Integer courseId);

    public Course getCourseByUserId(Integer id);
}
