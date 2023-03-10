package com.example.gztruyen.model;

import com.google.gson.annotations.SerializedName;

public class Fields {
    private Image Image;
    @SerializedName("chapTitle")
    private Title title;

    @SerializedName("chapContent")
    private Content chapContent;

    public Image getImage() {
        return Image;
    }

    public Title getTitle() {
        return title;
    }

    public Content getChapContent(){return chapContent;}
    public void setImage(Image Image) {
        this.Image = Image;
    }

    public static class Title {
        private String stringValue;

        public Title(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getStringValue() {
            return stringValue;
        }
    }
    public static class Content{
        private String stringValue;
        public Content(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getStringValue() {
            return stringValue;
        }
    }
}
