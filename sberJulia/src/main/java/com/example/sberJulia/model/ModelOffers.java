package com.example.sberJulia.model;

import java.io.Serializable;

public class ModelOffers implements Serializable {
    private ModelContent content;

    public ModelOffers() {
    }

    public ModelOffers(ModelContent content) {
        this.content = content;
    }

    public ModelContent getContent() {
        return content;
    }

    public void setContent(ModelContent content) {
        this.content = content;
    }
}
