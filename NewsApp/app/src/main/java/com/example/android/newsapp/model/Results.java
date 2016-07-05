package com.example.android.newsapp.model;

import android.graphics.Bitmap;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */

public class Results {
    private String id;

    private String webUrl;

    private String sectionId;

    private String isHosted;

    private String apiUrl;

    private String sectionName;

    private String webTitle;

    private String type;

    private String webPublicationDate;

    private Fields fields;

    private Bitmap image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getIsHosted() {
        return isHosted;
    }

    public void setIsHosted(String isHosted) {
        this.isHosted = isHosted;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", webUrl = " + webUrl + ", sectionId = " + sectionId + ", isHosted = " + isHosted + ", apiUrl = " + apiUrl + ", sectionName = " + sectionName + ", webTitle = " + webTitle + ", type = " + type + ", webPublicationDate = " + webPublicationDate + ", fields = " + fields + "]";
    }
}

