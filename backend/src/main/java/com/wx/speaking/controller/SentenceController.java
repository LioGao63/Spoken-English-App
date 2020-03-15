package com.wx.speaking.controller;
import com.alibaba.fastjson.*;

import java.util.ArrayList;
import java.util.List;


public class SentenceController {

    public static String resolveJson(String json){

        JSONObject resultJson = new JSONObject();//返回的结果JSON

        JSONObject dataOfJson; //评测数据

        JSONObject readChapter; //章节评测部分

        JSONObject wordJson;//单词评测部分

        Object category;//识别种类：单词或句子

        double total_score;//总分

        double accuracy_score;//准确度得分

        double fluency_score;//流畅度得分

        double integrity_score;//完整度得分

        List<Double> wordScore = new ArrayList<>();
        List<Integer> dp_message = new ArrayList<>();

        //异常状态码(28673:无语音输入或音量太小; 28676:检测到语音为乱说类型;
        // 28680:音频数据信噪比太低,音噪比在1.7以下; 28709:音频数据信噪比太低，音噪比在0.7以下; 28690:音频数据出现截幅)
        int except_info;

        String is_rejected;//"true"为乱读，反之正常


        //获取json最外层对象
        JSONObject jsonObject = JSONObject.parseObject(json);
        dataOfJson = jsonObject.getJSONObject("data");//获取数据对象

        readChapter = (JSONObject) JSONPath.eval(dataOfJson, "$.read_sentence.rec_paper.read_chapter");
        except_info = readChapter.getInteger("except_info");
        is_rejected = readChapter.getString("is_rejected");

        if(except_info !=0){
            resultJson.put("info", except_info);
            return resultJson.toJSONString();
        }else{
            resultJson.put("info", except_info);
        }


        if(is_rejected == "true"){
            resultJson.put("msg", "rejected");
            System.out.println("检测为乱读");
            return resultJson.toJSONString();
        }else{
            resultJson.put("msg", "success");
        }

        total_score = readChapter.getDouble("total_score");
        accuracy_score = readChapter.getDouble("accuracy_score");
        fluency_score = readChapter.getDouble("fluency_score");
        integrity_score = readChapter.getDouble("integrity_score");

        wordJson = (JSONObject) JSONPath.eval(readChapter, "$.sentence");
        wordScore = (List<Double>) JSONPath.eval(wordJson,"$.word[*].total_score");//获取每个单词得分
        dp_message = (List<Integer>) JSONPath.eval(wordJson, "$.word[*].dp_message");
        resultJson.put("wordScore", wordScore);
        resultJson.put("dp", dp_message);

        System.out.println(resultJson.toJSONString());
        return resultJson.toJSONString();
    }

    public static void main(String[] args) {
        SentenceController.resolveJson("{\"data\": {\"read_sentence\": {\"lan\": \"en\", \"type\": \"study\", \"version\": \"6.5.0.1011\", \"rec_paper\": {\"read_chapter\": {\"end_pos\": \"649\", \"integrity_score\": \"75.000000\", \"total_score\": \"58.585080\", \"word_count\": \"8\", \"standard_score\": \"28.896380\", \"sentence\": {\"index\": \"0\", \"standard_score\": \"28.896380\", \"total_score\": \"58.585080\", \"word\": [{\"dp_message\": \"0\", \"global_index\": \"0\", \"index\": \"0\", \"property\": \"0\", \"total_score\": \"44.340820\", \"beg_pos\": \"3\", \"content\": \"she\", \"end_pos\": \"76\", \"syll\": {\"syll_accent\": \"0\", \"syll_score\": \"44.340820\", \"phone\": [{\"content\": \"sh\", \"dp_message\": \"0\", \"end_pos\": \"52\", \"beg_pos\": \"3\"}, {\"dp_message\": \"0\", \"end_pos\": \"76\", \"beg_pos\": \"52\", \"content\": \"iy\"}], \"beg_pos\": \"3\", \"content\": \"sh iy\", \"end_pos\": \"76\"}}, {\"beg_pos\": \"76\", \"content\": \"sil\", \"end_pos\": \"106\"}, {\"content\": \"refused\", \"end_pos\": \"198\", \"syll\": [{\"end_pos\": \"132\", \"syll_accent\": \"0\", \"syll_score\": \"92.752500\", \"phone\": [{\"beg_pos\": \"106\", \"content\": \"r\", \"dp_message\": \"0\", \"end_pos\": \"124\"}, {\"beg_pos\": \"124\", \"content\": \"ih\", \"dp_message\": \"0\", \"end_pos\": \"132\"}], \"beg_pos\": \"106\", \"content\": \"r ih\"}, {\"content\": \"f y uw z d\", \"end_pos\": \"198\", \"syll_accent\": \"1\", \"syll_score\": \"65.397400\", \"phone\": [{\"beg_pos\": \"132\", \"content\": \"f\", \"dp_message\": \"0\", \"end_pos\": \"145\"}, {\"beg_pos\": \"145\", \"content\": \"y\", \"dp_message\": \"0\", \"end_pos\": \"154\"}, {\"dp_message\": \"0\", \"end_pos\": \"168\", \"beg_pos\": \"154\", \"content\": \"uw\"}, {\"beg_pos\": \"168\", \"content\": \"z\", \"dp_message\": \"0\", \"end_pos\": \"184\"}, {\"beg_pos\": \"184\", \"content\": \"d\", \"dp_message\": \"0\", \"end_pos\": \"198\"}], \"beg_pos\": \"132\"}], \"property\": \"0\", \"total_score\": \"73.213120\", \"beg_pos\": \"106\", \"dp_message\": \"0\", \"global_index\": \"1\", \"index\": \"1\"}, {\"property\": \"0\", \"total_score\": \"0.000000\", \"beg_pos\": \"198\", \"content\": \"to\", \"dp_message\": \"16\", \"end_pos\": \"198\", \"global_index\": \"2\", \"index\": \"2\"}, {\"beg_pos\": \"198\", \"content\": \"sil\", \"end_pos\": \"269\"}, {\"property\": \"0\", \"total_score\": \"86.974720\", \"beg_pos\": \"269\", \"end_pos\": \"336\", \"global_index\": \"3\", \"index\": \"3\", \"content\": \"speak\", \"dp_message\": \"0\", \"syll\": {\"beg_pos\": \"269\", \"content\": \"s b iy k\", \"end_pos\": \"336\", \"syll_accent\": \"0\", \"syll_score\": \"86.974720\", \"phone\": [{\"beg_pos\": \"269\", \"content\": \"s\", \"dp_message\": \"0\", \"end_pos\": \"286\"}, {\"beg_pos\": \"286\", \"content\": \"b\", \"dp_message\": \"0\", \"end_pos\": \"299\"}, {\"beg_pos\": \"299\", \"content\": \"iy\", \"dp_message\": \"0\", \"end_pos\": \"310\"}, {\"content\": \"k\", \"dp_message\": \"0\", \"end_pos\": \"336\", \"beg_pos\": \"310\"}]}}, {\"index\": \"4\", \"property\": \"0\", \"total_score\": \"0.000000\", \"beg_pos\": \"336\", \"content\": \"to\", \"dp_message\": \"16\", \"end_pos\": \"336\", \"global_index\": \"4\"}, {\"beg_pos\": \"336\", \"content\": \"sil\", \"end_pos\": \"383\"}, {\"total_score\": \"93.102220\", \"beg_pos\": \"383\", \"global_index\": \"5\", \"end_pos\": \"424\", \"index\": \"5\", \"property\": \"0\", \"syll\": {\"phone\": [{\"dp_message\": \"0\", \"end_pos\": \"394\", \"beg_pos\": \"383\", \"content\": \"m\"}, {\"beg_pos\": \"394\", \"content\": \"iy\", \"dp_message\": \"0\", \"end_pos\": \"424\"}], \"beg_pos\": \"383\", \"content\": \"m iy\", \"end_pos\": \"424\", \"syll_accent\": \"0\", \"syll_score\": \"93.102220\"}, \"content\": \"me\", \"dp_message\": \"0\"}, {\"beg_pos\": \"424\", \"content\": \"sil\", \"end_pos\": \"439\"}, {\"beg_pos\": \"439\", \"dp_message\": \"0\", \"end_pos\": \"464\", \"global_index\": \"6\", \"index\": \"6\", \"property\": \"0\", \"total_score\": \"66.855140\", \"content\": \"at\", \"syll\": {\"beg_pos\": \"439\", \"content\": \"ae t\", \"end_pos\": \"464\", \"syll_accent\": \"0\", \"syll_score\": \"66.855140\", \"phone\": [{\"beg_pos\": \"439\", \"content\": \"ae\", \"dp_message\": \"0\", \"end_pos\": \"458\"}, {\"end_pos\": \"464\", \"beg_pos\": \"458\", \"content\": \"t\", \"dp_message\": \"0\"}]}}, {\"content\": \"first\", \"global_index\": \"7\", \"property\": \"0\", \"index\": \"7\", \"total_score\": \"98.509020\", \"syll\": {\"syll_score\": \"98.509020\", \"phone\": [{\"beg_pos\": \"464\", \"content\": \"f\", \"dp_message\": \"0\", \"end_pos\": \"480\"}, {\"content\": \"er\", \"dp_message\": \"0\", \"end_pos\": \"487\", \"beg_pos\": \"480\"}, {\"beg_pos\": \"487\", \"content\": \"r\", \"dp_message\": \"0\", \"end_pos\": \"496\"}, {\"dp_message\": \"0\", \"end_pos\": \"512\", \"beg_pos\": \"496\", \"content\": \"s\"}, {\"beg_pos\": \"512\", \"content\": \"t\", \"dp_message\": \"0\", \"end_pos\": \"527\"}], \"beg_pos\": \"464\", \"content\": \"f er r s t\", \"end_pos\": \"527\", \"syll_accent\": \"0\"}, \"beg_pos\": \"464\", \"dp_message\": \"0\", \"end_pos\": \"527\"}], \"accuracy_score\": \"64.193380\", \"beg_pos\": \"0\", \"fluency_score\": \"52.976780\", \"content\": \"she refused to speak to me at first\", \"end_pos\": \"649\", \"word_count\": \"8\"}, \"accuracy_score\": \"64.193380\", \"beg_pos\": \"0\", \"content\": \"She refused to speak to me at first.\", \"except_info\": \"0\", \"fluency_score\": \"52.976780\", \"is_rejected\": \"false\"}}}}, \"code\": \"0\", \"desc\": \"success\", \"sid\": \"wse019a1433@dxddfb11c97b476f1a00\"}");
    }
}
