package com.peak.ssm.pojo;

import lombok.Data;

@Data
public class Friend {
    private int id;
    private String siteName;
    private String path;
    private String desc;

    public Friend() {
    }

    public Friend(int id, String siteName, String path, String desc) {
        this.id = id;
        this.siteName = siteName;
        this.path = path;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
