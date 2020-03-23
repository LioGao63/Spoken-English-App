package com.wx.speaking.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.wx.speaking.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    @Autowired
    WordMapper wordMapper;

    public static String resolveWordJson(String json){

        JSONObject resultJson = new JSONObject();//返回的结果JSON
        JSONObject read_word; //章节评测部分

        DecimalFormat df = new DecimalFormat("#.00"); //定义小数点后两位的格式

        //异常状态码(28673:无语音输入或音量太小; 28676:检测到语音为乱说类型;
        // 28680:音频数据信噪比太低,音噪比在1.7以下; 28709:音频数据信噪比太低，音噪比在0.7以下; 28690:音频数据出现截幅)
        int except_info;
        double total_score;
        String is_rejected;//"true"为乱读，反之正常


        //获取json最外层对象
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject dataOfJson = jsonObject.getJSONObject("data");//获取数据对象

        read_word = (JSONObject) JSONPath.eval(dataOfJson, "$.read_word.rec_paper.read_word");

        //获取状态码
        except_info = read_word.getInteger("except_info");
        System.out.println(except_info);
        is_rejected = read_word.getString("is_rejected");


        if(except_info !=0){
            resultJson.put("info", except_info);
            System.out.println(resultJson);
            return resultJson.toJSONString();
        }else{
            resultJson.put("info", except_info);
        }


        if(is_rejected == "true"){
            resultJson.put("msg", "rejected");
            System.out.println("检测为乱读");
            return resultJson.toJSONString();
        }else{
            System.out.println("成功");
            resultJson.put("msg", "success");
        }

        total_score = Double.parseDouble(df.format(read_word.getDouble("total_score")));

        resultJson.put("total_score", total_score);
        String result = resultJson.toJSONString();
        System.out.println(result);
        return resultJson.toJSONString();
    }

}
