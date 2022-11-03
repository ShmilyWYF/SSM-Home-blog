package com.peak.ssm.uiltr;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class CookieUtilr {
   public static void setCookie(HttpServletRequest request, HttpServletResponse response, Cookie... cookie) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //设置响应编码格式
        response.setCharacterEncoding("UTF-8");
        //设置数据返回的类型
        response.setContentType("text/json");

       for (Cookie key:cookie) {
           key.setMaxAge(3*24*3600);
           response.addCookie(key);
       }

    }

    public static Map<String,Object> getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置数据返回的类型
        response.setContentType("text/json");
        //设置请求编码格式
        request.setCharacterEncoding("UTF-8");
        //设置响应编码格式
        response.setCharacterEncoding("UTF-8");
        //获取Cookie信息数组
        Cookie[] cks=request.getCookies();
        Map<String,Object> map=new HashMap<>();
        String username="";
        String password="";
        if(cks!=null){
            for (Cookie key:cks) {
                if("username".equals(key.getName())){
                    username=key.getValue();
                }
                if("password".equals(key.getName())){
                    password=key.getValue();
                }
            }
            map.put("username",username);
            map.put("password",password);
            return map;
        }else {
            return map;
        }
    }
}
