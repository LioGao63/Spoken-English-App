package com.wx.speaking.bean;

public class Word {

    private Integer id;
    private String word;
    private String videoPath;
    private Integer courseId;
    private Double score;
    private Integer flag;
    private Integer count;


    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", courseId=" + courseId +
                ", score=" + score +
                ", flag=" + flag +
                ", count=" + count +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double totalScore) {
        this.score = totalScore;
    }

    public Integer getFlag() { return flag; }

    public void setFlag(Integer flag) { this.flag = flag; }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
