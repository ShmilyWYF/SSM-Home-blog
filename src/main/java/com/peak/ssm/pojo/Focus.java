package com.peak.ssm.pojo;

import lombok.Data;

@Data
public class Focus {
    private int id;
    private String title;
    private String img;
    private String href;

    public Focus(int id, String title, String img, String href) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.href = href;
    }

    public Focus() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
