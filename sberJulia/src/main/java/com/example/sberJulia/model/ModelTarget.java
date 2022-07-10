package com.example.sberJulia.model;

import java.io.Serializable;
import java.util.List;

public class ModelTarget implements Serializable {
    private String userGuid;
    private List<ModelOffersTarget> offers;

    public ModelTarget() {
    }

    public ModelTarget(String userGuid, List<ModelOffersTarget> offers) {
        this.userGuid = userGuid;
        this.offers = offers;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public List<ModelOffersTarget> getOffers() {
        return offers;
    }

    public void setOffers(List<ModelOffersTarget> offers) {
        this.offers = offers;
    }
}
