package com.example.gztruyen.model;

import com.google.type.DateTime;

public class CommicModel {
    public int Id ;

    public int AuthorId ;

    public byte Status ;

    public int ViewCount ;

    public int RateCount;

    public int FollowCount;
    public String Description ;

    public DateTime CreatedAt ;

    public DateTime ModifiedAt;

    public byte IsActive;

    public int Type;

    public String Title;

    public String ImageShow ;

    public String CategryId ;

    public String ImageBanner;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void setViewCount(int viewCount) {
        ViewCount = viewCount;
    }

    public int getRateCount() {
        return RateCount;
    }

    public void setRateCount(int rateCount) {
        RateCount = rateCount;
    }

    public int getFollowCount() {
        return FollowCount;
    }

    public void setFollowCount(int followCount) {
        FollowCount = followCount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public DateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        CreatedAt = createdAt;
    }

    public DateTime getModifiedAt() {
        return ModifiedAt;
    }

    public void setModifiedAt(DateTime modifiedAt) {
        ModifiedAt = modifiedAt;
    }

    public byte getIsActive() {
        return IsActive;
    }

    public void setIsActive(byte isActive) {
        IsActive = isActive;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImageShow() {
        return ImageShow;
    }

    public void setImageShow(String imageShow) {
        ImageShow = imageShow;
    }

    public String getCategryId() {
        return CategryId;
    }

    public void setCategryId(String categryId) {
        CategryId = categryId;
    }

    public String getImageBanner() {
        return ImageBanner;
    }

    public void setImageBanner(String imageBanner) {
        ImageBanner = imageBanner;
    }
}
