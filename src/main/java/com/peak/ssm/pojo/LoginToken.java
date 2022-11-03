package com.peak.ssm.pojo;


public class LoginToken {
    private static String token;

    public LoginToken() {}


    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        LoginToken.token = token;
    }

}

