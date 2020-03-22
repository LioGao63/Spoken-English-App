package com.wx.speaking.mapper;

import com.wx.speaking.bean.Sentence;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SentenceMapper {

    public Sentence getSentenceById(Integer id);

    public void updateSentence(Sentence sentence);

    public List<Sentence> getAllSentence();

    public List<Sentence> getSentenceList(Integer courseId);


}
