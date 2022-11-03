package com.peak.ssm.pojo;

import lombok.Data;

@Data
public class Social {
    private int id;
    private String title;
    private String icon;
    private String color;
    private String href;

    public Social(int id, String title, String icon, String color, String href) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.color = color;
        this.href = href;
    }

    public Social() {
    }
}
