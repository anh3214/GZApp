package com.example.gztruyen.model;

public class ChapterModel {
    private Long id;
    private String image;
    private String name;
    private String createTime;

    public ChapterModel() {
    }

    public ChapterModel(Long id, String image, String name, String createTime) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
