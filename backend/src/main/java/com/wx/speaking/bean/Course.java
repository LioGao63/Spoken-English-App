package com.wx.speaking.bean;

public class Course {

    private Integer id;//课程id

    private String name;//课程名

    @Override
    public String toString() {
        return "Cource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
