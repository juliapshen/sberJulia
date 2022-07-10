package com.example.sberJulia.model;

import java.io.Serializable;

public class ModelViewed implements Serializable {
    private String contentGuid;
    private String userGuid;

    public ModelViewed() {
    }

    public ModelViewed(String contentGuid, String userGuid) {
        this.contentGuid = contentGuid;
        this.userGuid = userGuid;
    }

    public String getContentGuid() {
        return contentGuid;
    }

    public void setContentGuid(String contentGuid) {
        this.contentGuid = contentGuid;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }
}