package com.peak.ssm.pojo;

import lombok.Data;

@Data
public class SiteInfo {
    private int id;
    private String avatar;
    private String slogan;
    private String name;
    private String domain;
    private String notice;

    public SiteInfo() {
    }

    public SiteInfo(int id, String avatar, String slogan, String name, String domain, String notice) {
        this.id = id;
        this.avatar = avatar;
        this.slogan = slogan;
        this.name = name;
        this.domain = domain;
        this.notice = notice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
