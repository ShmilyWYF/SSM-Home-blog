package com.peak.ssm.pojo;

import java.io.Serializable;

public class LoginRoles<T> implements Serializable {
    private int id;
    private T name;
    private T avatar;
    private T introduction;
    private T role;

    private T[] roles;

    public LoginRoles() {}

    public LoginRoles(int id, T name, T avatar, T introduction, T[] roles) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.introduction = introduction;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getAvatar() {
        return avatar;
    }

    public void setAvatar(T avatar) {
        this.avatar = avatar;
    }

    public T getIntroduction() {
        return introduction;
    }

    public void setIntroduction(T introduction) {
        this.introduction = introduction;
    }

    public T getRole() {
        return role;
    }

    public void setRole(T role) {
        this.role = role;
    }

    public T[] getRoles() {
        return roles;
    }

    public void setRoles(T[] roles) {
        this.roles = roles;
    }
}

