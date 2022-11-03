package com.peak.ssm.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class BlogwebFetchList {
    private int id;
    private String title;
    private String desc;
    private String name;
    private FetchList fetchList;

    public BlogwebFetchList(int id, String title, String desc, String name, FetchList fetchList) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.name = name;
        this.fetchList = fetchList;
    }

    public BlogwebFetchList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FetchList getFetchList() {
        return fetchList;
    }

    public void setFetchList(FetchList fetchList) {
        this.fetchList = fetchList;
    }
}
