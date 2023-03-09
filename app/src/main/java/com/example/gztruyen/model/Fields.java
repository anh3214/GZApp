package com.example.gztruyen.model;

public class Fields {
    private Image Image;
    private Title title;

    public Image getImage() {
        return Image;
    }

    public Title getTitle() {
        return title;
    }

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
}
