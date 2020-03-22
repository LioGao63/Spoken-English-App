package com.wx.speaking.bean;

public class Course {

    private Integer id;//课程id

    private String name;//课程名

    private String course_image;//课程图片

    private Integer difficulty;

    private Integer count;

    private Integer type;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course_image='" + course_image + '\'' +
                ", difficulty=" + difficulty +
                ", count=" + count +
                ", type=" + type +
                '}';
    }

    public String getCourse_image() {
        return course_image;
    }

    public void setCourse_image(String course_image) {
        this.course_image = course_image;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
