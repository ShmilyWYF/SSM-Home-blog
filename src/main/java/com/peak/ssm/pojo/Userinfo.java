package com.peak.ssm.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Userinfo {
    private int id;
    private String username;
    private String password;
    private LoginRoles loginRoles;

    public Userinfo() {
    }

    public Userinfo(int id, String username, String password, LoginRoles loginRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loginRoles = loginRoles;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loginRoles=" + JSON.toJSONString(loginRoles) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRoles getLoginRoles() {
        return loginRoles;
    }

    public void setLoginRoles(LoginRoles loginRoles) {
        this.loginRoles = loginRoles;
    }
}
