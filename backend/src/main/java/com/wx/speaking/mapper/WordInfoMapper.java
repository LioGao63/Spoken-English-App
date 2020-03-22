package com.wx.speaking.mapper;

import com.wx.speaking.bean.WordInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordInfoMapper {
    //插入用户的单词分数
    void insertWordInfo(String userId, Integer wordId, double score);

    //跟新用户的单词分数
    void updateWordInfo(String userId, Integer wordId, Double score);

    //查找用户的单词分数
    WordInfo getWordInfo(String userId, Integer wordId);

    //删除用户的单词分数
    void deleteWordInfo(String userId, Integer wordId);

}
