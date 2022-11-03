package com.peak.ssm.pojo;

import lombok.Data;

@Data
public class Blog {
    private int id;
    private String t_body;
    private String t_time;

    public Blog() {}

    public Blog(int id, String t_body, String t_time) {
        this.id = id;
        this.t_body = t_body;
        this.t_time = t_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT_body() {
        return t_body;
    }

    public void setT_body(String t_body) {
        this.t_body = t_body;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }
}
