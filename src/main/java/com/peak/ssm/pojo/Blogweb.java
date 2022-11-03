package com.peak.ssm.pojo;

import lombok.Data;

@Data
public class Blogweb {
    private int id;
    private String title;
    private String desc;
    private String name;

    public Blogweb() {
    }

    public Blogweb(int id, String title, String desc, String name) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.name = name;
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
}
