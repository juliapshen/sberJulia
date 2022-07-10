package com.example.sberJulia.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ModelTargetOffers implements Serializable {
    private String page;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date startDate;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date endDate;
    private List<ModelTarget> target;

    public ModelTargetOffers() {
    }

    public ModelTargetOffers(String page, Date startDate, Date endDate, List<ModelTarget> target) {
        this.page = page;
        this.startDate = startDate;
        this.endDate = endDate;
        this.target = target;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<ModelTarget> getTarget() {
        return target;
    }

    public void setTarget(List<ModelTarget> target) {
        this.target = target;
    }
}
