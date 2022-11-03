package com.peak.ssm.uiltr;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.pojo.LoginRoles;
import com.peak.ssm.pojo.Userinfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RolesParseUtilr {

    public static void rolesparse(HttpServletRequest request, List<Userinfo> userinfo){

        //获取集合元素对象，将解析被转换成对象的json转换成map
        Map map=(Map) JSON.parse(JSON.toJSONString(userinfo.get(0).getLoginRoles()));

        //角色信息
        LoginRoles loginRoles=new LoginRoles();
        loginRoles.setName(map.get("name"));
        loginRoles.setAvatar(map.get("avatar"));
        loginRoles.setIntroduction(map.get("introduction"));
        loginRoles.setRoles(new Object[]{map.get("role")});

        //放进缓存  根据用户token得到信息
        SessionTools.createSession(request,request.getSession().getAttribute("token"), loginRoles);

    }

}
