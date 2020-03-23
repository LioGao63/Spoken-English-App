package com.wx.speaking.mapper;

import com.wx.speaking.bean.SentenceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SentenceInfoMapper {
    //插入用户的句子分数
    void insertSentenceInfo(String userId, Integer sentenceId, Double totalScore,
                            Double accuracyScore, Double fluencyScore, Double integrityScore);

    //更新用户的句子分数
    void updateSentenceInfo(String userId, Integer sentenceId, Double totalScore,
                            Double accuracyScore, Double fluencyScore, Double integrityScore);

    //查找用户的句子分数
    SentenceInfo getSentenceInfo(String userId, Integer sentenceId);

    //删除用户的句子分数
    void deleteSentenceInfo(String userId, Integer sentenceId);
}
