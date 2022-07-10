package com.example.sberJulia.model;

import java.io.Serializable;

public class ModelPublishedContent implements Serializable {
    private String contentGuid;

    private String data;

    public ModelPublishedContent() {
    }

    public ModelPublishedContent(String contentGuid, String data) {
        this.contentGuid = contentGuid;
        this.data = data;
    }

    public String getContentGuid() {
        return contentGuid;
    }

    public void setContentGuid(String contentGuid) {
        this.contentGuid = contentGuid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
