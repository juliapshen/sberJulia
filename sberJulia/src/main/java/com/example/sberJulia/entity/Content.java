package com.example.sberJulia.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "content")
public class Content {
    @Id
    private String guid;
    private String data;

    public Content() {
    }

    public Content(String guid, String data, List<Viewed> viewed) {
        this.guid = guid;
        this.data = data;
        this.viewed = viewed;
    }

    @OneToMany(mappedBy = "content")
    private List<Viewed> viewed;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Viewed> getViewed() {
        return viewed;
    }

    public void setViewed(List<Viewed> viewed) {
        this.viewed = viewed;
    }
}
