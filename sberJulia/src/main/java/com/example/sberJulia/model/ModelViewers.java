package com.example.sberJulia.model;

import java.io.Serializable;
import java.util.List;

public class ModelViewers implements Serializable {
    private List<ModelViewed> viewed;

    public ModelViewers() {
    }

    public ModelViewers(List<ModelViewed> viewed) {
        this.viewed = viewed;
    }

    public List<ModelViewed> getViewed() {
        return viewed;
    }

    public void setViewed(List<ModelViewed> viewed) {
        this.viewed = viewed;
    }
}
