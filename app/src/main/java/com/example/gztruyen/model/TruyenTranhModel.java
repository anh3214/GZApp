package com.example.gztruyen.model;

import android.net.Uri;

import java.util.Date;

public class TruyenTranhModel {
    public String id;

    public String Name;

    public String Image;

    public String Description;


    public TruyenTranhModel() {
    }

    public TruyenTranhModel(String id, String name, String description, String image) {
        this.id = id;
        Name = name;
        Description = description;
        Image = image;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }

}
