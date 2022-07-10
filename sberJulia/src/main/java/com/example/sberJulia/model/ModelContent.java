package com.example.sberJulia.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ModelContent implements Serializable {
    private String data;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date loadDate;
    private int priority;

    public ModelContent() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ModelContent(String data, Date loadDate, int priority) {
        this.data = data;
        this.loadDate = loadDate;
        this.priority = priority;
    }
}
