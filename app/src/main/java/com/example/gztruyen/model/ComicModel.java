package com.example.gztruyen.model;

import java.util.List;

public class ComicModel {
    private String name;
    private Fields fields;
    private String createTime;
    private String updateTime;
    private List<String> Avatar;

    public ComicModel(String name, Fields fields, String createTime, String updateTime) {
        this.name = name;
        this.fields = fields;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    public ComicModel(){

    }

    public List<String> getAvatar() {
        return Avatar;
    }

    public void setAvatar(List<String> avatar) {
        Avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public Fields getFields() {
        return fields;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public static class Fields {
        private final ImageShow ImageShow;
        private final Title Title;
        private final Description Description;

        public Fields(ImageShow imageShow, Title title, Description description) {
            ImageShow = imageShow;
            Title = title;
            Description = description;
        }

        public ImageShow getImageShow() {
            return ImageShow;
        }

        public Title getTitle() {
            return Title;
        }

        public Description getDescription() {
            return Description;
        }
    }

    public static class ImageShow {
        private final String stringValue;

        public ImageShow(String referenceValue) {
            this.stringValue = referenceValue;
        }

        public String getReferenceValue() {
            return stringValue;
        }
    }

    public static class Title {
        private final String stringValue;

        public Title(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getStringValue() {
            return stringValue;
        }
    }

    public static class Description {
        private final String stringValue;

        public Description(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getStringValue() {
            return stringValue;
        }
    }
}

