package com.example.gztruyen.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruyenHot {
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
    public static class Fields{
        private Ishot Ishot;
        private ImageShow ImageShow;

        public ImageShow getImageShow() {
            return ImageShow;
        }

        public void setImageShow(ImageShow imageShow) {
            this.ImageShow = imageShow;
        }

        public Ishot getIshot() {
            return Ishot;
        }

        public void setIshot(Ishot ishot) {
            this.Ishot = ishot;
        }
    }
    public static class ImageShow{
        private String stringValue;

        public String getStringValue() {
            return stringValue;
        }

        public void setStringValue(String stringValue) {
            this.stringValue = stringValue;
        }
    }
    public static class Ishot{
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

