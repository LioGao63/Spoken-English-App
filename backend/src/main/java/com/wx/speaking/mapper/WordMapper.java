package com.wx.speaking.mapper;

import com.wx.speaking.bean.Word;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {

    public Word getWordById(int id);

    public List<Word> getWordList(int courseId);

    public void updateWord(Word word);

    public List<Word> getAllWord();

}
