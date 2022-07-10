package com.example.sberJulia.model;

import java.io.Serializable;
import java.util.List;

public class ModelPublishedContentList implements Serializable {
    private List<ModelPublishedContent> content;

    public List<ModelPublishedContent> getContent() {
        return content;
    }

    public void setContent(List<ModelPublishedContent> content) {
        this.content = content;
    }

    public ModelPublishedContentList(List<ModelPublishedContent> content) {
        this.content = content;
    }

    public ModelPublishedContentList() {
    }
}
