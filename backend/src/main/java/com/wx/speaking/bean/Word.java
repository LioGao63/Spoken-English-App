package com.wx.speaking.bean;

public class Word {

    private Integer id;
    private String word;
    private String videoPath;
    private Integer courseId;
//    private Double accuracyScore;
//    private Double fluencyScore;
//    private Double integrityScore;
    private Double totalScore;
    private Integer flag;


    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", courseId=" + courseId +
                ", totalScore=" + totalScore +
                ", flag='" + flag + '\'' +
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

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getFlag() { return flag; }

    public void setFlag(Integer flag) { this.flag = flag; }
}
