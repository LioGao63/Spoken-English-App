package com.wx.speaking.mapper;

import com.wx.speaking.bean.Sign;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignMapper {

    public void addSignUser(String userId);

    public Sign getSignById(String userId);

}
