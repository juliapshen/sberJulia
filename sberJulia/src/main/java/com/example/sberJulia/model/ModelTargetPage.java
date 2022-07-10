package com.example.sberJulia.model;

import java.io.Serializable;

public class ModelTargetPage implements Serializable {
    private String page;
    private String user_guid;

    public ModelTargetPage() {
    }

    public ModelTargetPage(String page, String user_guid) {
        this.page = page;
        this.user_guid = user_guid;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getUser_guid() {
        return user_guid;
    }

    public void setUser_guid(String user_guid) {
        this.user_guid = user_guid;
    }
}
