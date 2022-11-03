package com.peak.ssm.pojo;

import lombok.Data;

@Data
public class UserRole {
    private int id;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private String introduction;
    private String role;
}
