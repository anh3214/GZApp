package com.example.gztruyen.model;

public class ChapterModel {
    private Long id;
    private String title;
    private String date;
    private boolean isNewest;

    public ChapterModel() {
    }

    public ChapterModel(Long id, String title, String date, boolean isNewest) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.isNewest = isNewest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isNewest() {
        return isNewest;
    }

    public void setNewest(boolean newest) {
        isNewest = newest;
    }
}
