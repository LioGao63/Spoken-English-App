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
        total_score = readChapter.getDouble("total_score");
        accuracy_score = readChapter.getDouble("accuracy_score");
        fluency_score = readChapter.getDouble("fluency_score");
        integrity_score = readChapter.getDouble("integrity_score");

        wordJson = (JSONObject) JSONPath.eval(readChapter, "$.sentence");
        wordScore = (List<Double>) JSONPath.eval(wordJson,"$.word[*].total_score");//获取每个单词得分
        System.out.println(wordScore);
        return resultJson.toJSONString();
    }

    public static void main(String[] args) {
        SentenceController.resolveJson("{\"sid\": \"wse0197dd4e@dxddfb11c81c4e6f1a00\", \"data\": {\"read_sentence\": {\"version\": \"6.5.0.1011\", \"rec_paper\": {\"read_chapter\": {\"is_rejected\": \"false\", \"total_score\": \"88.955440\", \"beg_pos\": \"0\", \"content\": \"She refused to speak to me(p0) at first.\", \"end_pos\": \"448\", \"except_info\": \"0\", \"word_count\": \"8\", \"sentence\": {\"accuracy_score\": \"80.262280\", \"content\": \"she refused to speak to me(p0) at first\", \"end_pos\": \"448\", \"standard_score\": \"46.969300\", \"beg_pos\": \"0\", \"fluency_score\": \"97.648580\", \"index\": \"0\", \"total_score\": \"88.955440\", \"word_count\": \"8\", \"word\": [{\"end_pos\": \"66\", \"index\": \"0\", \"property\": \"0\", \"syll\": {\"beg_pos\": \"27\", \"content\": \"sh iy\", \"end_pos\": \"66\", \"syll_accent\": \"0\", \"syll_score\": \"95.044740\", \"phone\": [{\"beg_pos\": \"27\", \"content\": \"sh\", \"dp_message\": \"0\", \"end_pos\": \"50\"}, {\"beg_pos\": \"50\", \"content\": \"iy\", \"dp_message\": \"0\", \"end_pos\": \"66\"}]}, \"beg_pos\": \"27\", \"content\": \"she\", \"dp_message\": \"0\", \"global_index\": \"0\", \"total_score\": \"95.044740\"}, {\"dp_message\": \"0\", \"end_pos\": \"138\", \"index\": \"1\", \"syll\": [{\"beg_pos\": \"66\", \"content\": \"r ih\", \"end_pos\": \"86\", \"syll_accent\": \"0\", \"syll_score\": \"75.992480\", \"phone\": [{\"end_pos\": \"80\", \"beg_pos\": \"66\", \"content\": \"r\", \"dp_message\": \"0\"}, {\"content\": \"ih\", \"dp_message\": \"0\", \"end_pos\": \"86\", \"beg_pos\": \"80\"}]}, {\"end_pos\": \"138\", \"syll_accent\": \"1\", \"syll_score\": \"55.024840\", \"phone\": [{\"end_pos\": \"98\", \"beg_pos\": \"86\", \"content\": \"f\", \"dp_message\": \"0\"}, {\"content\": \"y\", \"dp_message\": \"0\", \"end_pos\": \"112\", \"beg_pos\": \"98\"}, {\"beg_pos\": \"112\", \"content\": \"uw\", \"dp_message\": \"0\", \"end_pos\": \"118\"}, {\"beg_pos\": \"118\", \"content\": \"z\", \"dp_message\": \"0\", \"end_pos\": \"130\"}, {\"beg_pos\": \"130\", \"content\": \"d\", \"dp_message\": \"0\", \"end_pos\": \"138\"}], \"beg_pos\": \"86\", \"content\": \"f y uw z d\"}], \"content\": \"refused\", \"global_index\": \"1\", \"property\": \"0\", \"total_score\": \"61.015600\", \"beg_pos\": \"66\"}, {\"beg_pos\": \"138\", \"content\": \"sil\", \"end_pos\": \"144\"}, {\"dp_message\": \"0\", \"global_index\": \"2\", \"index\": \"2\", \"total_score\": \"58.978620\", \"beg_pos\": \"144\", \"content\": \"to\", \"syll\": {\"end_pos\": \"164\", \"syll_accent\": \"0\", \"syll_score\": \"58.978620\", \"phone\": [{\"beg_pos\": \"144\", \"content\": \"t\", \"dp_message\": \"0\", \"end_pos\": \"158\"}, {\"beg_pos\": \"158\", \"content\": \"uw\", \"dp_message\": \"0\", \"end_pos\": \"164\"}], \"beg_pos\": \"144\", \"content\": \"t uw\"}, \"end_pos\": \"164\", \"property\": \"0\"}, {\"beg_pos\": \"164\", \"content\": \"speak\", \"dp_message\": \"0\", \"end_pos\": \"210\", \"index\": \"3\", \"property\": \"0\", \"global_index\": \"3\", \"total_score\": \"65.903000\", \"syll\": {\"beg_pos\": \"164\", \"content\": \"s b iy k\", \"end_pos\": \"210\", \"syll_accent\": \"0\", \"syll_score\": \"65.903000\", \"phone\": [{\"beg_pos\": \"164\", \"content\": \"s\", \"dp_message\": \"0\", \"end_pos\": \"178\"}, {\"beg_pos\": \"178\", \"content\": \"b\", \"dp_message\": \"0\", \"end_pos\": \"193\"}, {\"beg_pos\": \"193\", \"content\": \"iy\", \"dp_message\": \"0\", \"end_pos\": \"198\"}, {\"beg_pos\": \"198\", \"content\": \"k\", \"dp_message\": \"0\", \"end_pos\": \"210\"}]}}, {\"index\": \"4\", \"property\": \"0\", \"beg_pos\": \"210\", \"content\": \"to\", \"end_pos\": \"230\", \"global_index\": \"4\", \"dp_message\": \"0\", \"total_score\": \"69.340400\", \"syll\": {\"beg_pos\": \"210\", \"content\": \"t uw\", \"end_pos\": \"230\", \"syll_accent\": \"0\", \"syll_score\": \"69.340400\", \"phone\": [{\"beg_pos\": \"210\", \"content\": \"t\", \"dp_message\": \"0\", \"end_pos\": \"224\"}, {\"beg_pos\": \"224\", \"content\": \"uw\", \"dp_message\": \"0\", \"end_pos\": \"230\"}]}}, {\"content\": \"me\", \"end_pos\": \"260\", \"total_score\": \"98.626240\", \"syll\": {\"content\": \"m iy\", \"end_pos\": \"260\", \"syll_accent\": \"0\", \"syll_score\": \"98.626240\", \"phone\": [{\"beg_pos\": \"230\", \"content\": \"m\", \"dp_message\": \"0\", \"end_pos\": \"240\"}, {\"dp_message\": \"0\", \"end_pos\": \"260\", \"beg_pos\": \"240\", \"content\": \"iy\"}], \"beg_pos\": \"230\"}, \"beg_pos\": \"230\", \"global_index\": \"5\", \"index\": \"5\", \"property\": \"2\", \"dp_message\": \"0\"}, {\"beg_pos\": \"260\", \"content\": \"sil\", \"end_pos\": \"278\"}, {\"beg_pos\": \"278\", \"index\": \"6\", \"total_score\": \"87.940980\", \"property\": \"0\", \"syll\": {\"beg_pos\": \"278\", \"content\": \"ae t\", \"end_pos\": \"302\", \"syll_accent\": \"0\", \"syll_score\": \"87.940980\", \"phone\": [{\"beg_pos\": \"278\", \"content\": \"ae\", \"dp_message\": \"0\", \"end_pos\": \"290\"}, {\"beg_pos\": \"290\", \"content\": \"t\", \"dp_message\": \"0\", \"end_pos\": \"302\"}]}, \"content\": \"at\", \"dp_message\": \"0\", \"end_pos\": \"302\", \"global_index\": \"6\"}, {\"end_pos\": \"359\", \"total_score\": \"98.888640\", \"syll\": {\"beg_pos\": \"302\", \"content\": \"f er r s t\", \"end_pos\": \"359\", \"syll_accent\": \"0\", \"syll_score\": \"98.888640\", \"phone\": [{\"beg_pos\": \"302\", \"content\": \"f\", \"dp_message\": \"0\", \"end_pos\": \"313\"}, {\"beg_pos\": \"313\", \"content\": \"er\", \"dp_message\": \"0\", \"end_pos\": \"318\"}, {\"beg_pos\": \"318\", \"content\": \"r\", \"dp_message\": \"0\", \"end_pos\": \"328\"}, {\"content\": \"s\", \"dp_message\": \"0\", \"end_pos\": \"342\", \"beg_pos\": \"328\"}, {\"beg_pos\": \"342\", \"content\": \"t\", \"dp_message\": \"0\", \"end_pos\": \"359\"}]}, \"index\": \"7\", \"property\": \"0\", \"beg_pos\": \"302\", \"content\": \"first\", \"dp_message\": \"0\", \"global_index\": \"7\"}]}, \"accuracy_score\": \"80.262280\", \"fluency_score\": \"97.648580\", \"integrity_score\": \"100.000000\", \"standard_score\": \"46.969300\"}}, \"lan\": \"en\", \"type\": \"study\"}}, \"code\": \"0\", \"desc\": \"success\"}");
    }
}
