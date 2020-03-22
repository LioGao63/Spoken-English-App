package com.wx.speaking.mapper;

import com.wx.speaking.bean.SentenceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SentenceInfoMapper {
    //插入用户的句子分数
    void insertSentenceInfo(SentenceInfo sentenceInfo);

    //跟新用户的句子分数
    void updateSentenceInfo(SentenceInfo sentenceInfo);

    //查找用户的句子分数
    SentenceInfo getSentenceInfo(String userId, Integer sentenceId);

    //删除用户的句子分数
    void deleteSentenceInfo(String userId, Integer sentenceId);
}
