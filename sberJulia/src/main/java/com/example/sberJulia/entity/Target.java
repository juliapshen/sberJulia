package com.example.sberJulia.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "target")
public class Target {
    @Id
    private String guid;

    @ManyToOne
    @JoinColumn(name = "user_guid", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "content_guid", nullable = false)
    private Content content;
    private String page;
    private int priority;
    private Date start_date;
    private Date end_date;

    public Target() {
    }

    public Target(String guid, Users users, Content content, String page, int priority, Date start_date, Date end_date) {
        this.guid = guid;
        this.users = users;
        this.content = content;
        this.page = page;
        this.priority = priority;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
