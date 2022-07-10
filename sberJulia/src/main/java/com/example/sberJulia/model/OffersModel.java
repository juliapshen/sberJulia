package com.example.sberJulia.model;

import java.util.List;

public class OffersModel {

    private List<ModelOffers> offers;

    public OffersModel(List<ModelOffers> offers) {
        this.offers = offers;
    }

    public OffersModel() {
    }

    public List<ModelOffers> getOffers() {
        return offers;
    }

    public void setOffers(List<ModelOffers> offers) {
        this.offers = offers;
    }
}