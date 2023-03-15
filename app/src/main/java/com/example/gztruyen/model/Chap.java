package com.example.gztruyen.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Chap {
    private List<Document> documents;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public static class Document {
        @SerializedName("name")
        private String name;

        @SerializedName("fields")
        private Fields fields;

        @SerializedName("createTime")
        private String createTime;

        @SerializedName("updateTime")
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
    }

    static class Fields {
        @SerializedName("Image")
        private Image image;

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }
    }

    static class Image {
        @SerializedName("referenceValue")
        private String referenceValue;

        public String getReferenceValue() {
            return referenceValue;
        }

        public void setReferenceValue(String referenceValue) {
            this.referenceValue = referenceValue;
        }
    }
}

