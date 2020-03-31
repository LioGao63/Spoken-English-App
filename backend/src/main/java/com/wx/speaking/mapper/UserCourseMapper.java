package com.wx.speaking.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCourseMapper {

    public Integer getCourseByUserAndCourseId(String id, Integer course_id);
}
