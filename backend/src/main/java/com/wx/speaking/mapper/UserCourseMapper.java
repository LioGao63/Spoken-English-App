package com.wx.speaking.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCourseMapper {

    public List<Integer> getCourseByUserId(String id);
}
