package com.example.sberJulia.model;

import java.io.Serializable;

public class ModelOffersTarget implements Serializable {
    private String contentGuid;
    private int priority;

    public ModelOffersTarget() {
    }

    public ModelOffersTarget(String contentGuid, int priority) {
        this.contentGuid = contentGuid;
        this.priority = priority;
    }

    public String getContentGuid() {
        return contentGuid;
    }

    public void setContentGuid(String contentGuid) {
        this.contentGuid = contentGuid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }
}
