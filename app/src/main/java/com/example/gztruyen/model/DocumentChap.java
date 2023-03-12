package com.example.gztruyen.model;

import com.google.gson.annotations.SerializedName;

public class DocumentChap {
    private String name;
    private Fields fields;
    private String createTime;
    private String updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public static class Fields {
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
        public static class Image {
            private String stringValue;

            public String getReferenceValue() {
                return stringValue;
            }

            public void setReferenceValue(String referenceValue) {
                this.stringValue = referenceValue;
            }
        }
    }
}
