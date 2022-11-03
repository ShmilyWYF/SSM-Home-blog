package com.peak.ssm.uiltr;

import javax.servlet.http.HttpServletRequest;

public class SessionTools {

    public static <T> void createSession(HttpServletRequest request,T key,T value){
        request.getSession().setAttribute(key.toString(), value);
    }

    public static Object getSession(HttpServletRequest request, String key){
        return request.getSession().getAttribute(key);
    }

    public  static void removeSession(HttpServletRequest request,String key){
        request.getSession().removeAttribute(key);
    }

}
