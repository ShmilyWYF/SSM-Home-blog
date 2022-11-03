package com.peak.ssm.uiltr;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.Blog;
import com.peak.ssm.pojo.LoginUser;
import com.peak.ssm.service.BlogServlet;
import com.peak.ssm.service.UserServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class IndexMethod {

    @Autowired
    private UserServlet userServlet;
    @Autowired
    private BlogServlet blogServlet;


    public  String isMethod(HttpServletRequest request, HttpServletResponse response,LoginUser user) {

        String MethodName = request.getParameter("methodName");
        //根据用户传递的方法执行对应方法

        switch (MethodName) {
            case "login":
                return userServlet.Roleslogin(user.getUsername(), user.getPassword());
            case "userinfo":
                return userServlet.Rolesinfo();
            case "logout":
                return userServlet.Rolesremove();
            default:
                return JSON.toJSONString(ResponseResult.failed("500","提交给服务器的方法错误"));
        }
    }

    public  String isMethod(HttpServletRequest request, HttpServletResponse response) {

        String MethodName = request.getParameter("methodName");

        System.out.println(MethodName);

        //根据用户传递的方法执行对应方法
        switch (MethodName) {
            case "add":
                //添加
                return blogServlet.addBlog();
            case "get":
                //查询
                return blogServlet.getAllBlog();
            case "updata":
                //更新
                return blogServlet.updataBlog();
            case "del":
                //删除
                return blogServlet.DelBlog();
/**javaweb和博客分界线------------------------------------***/
            case "fetchSiteInfogetAll":
                //获取社交信息
                return blogServlet.fetchSiteInfogetAll();
            case "fetchSiteInfoUpdate":
                //更新社交信息
                return blogServlet.fetchSiteInfoUpdate();
            case "fetchSocial":
                //获取我的社交各平台地址
                return blogServlet.fetchSocial();
            case "fetchFocus":
                //获取焦点
                return blogServlet.fetchFocus();
            case "fetchList":
                //获取列表
                return blogServlet.fetchList();
            case "fetchFriend":
                //找朋友
                return blogServlet.fetchFriend();
            case "fetchblogweb":
                //添加文章
                return blogServlet.fetchblogweb();
            default:
                return JSON.toJSONString(ResponseResult.failed("500","提交给服务器的方法错误"));
        }
    }

    public  String isMethod(HttpServletRequest request, HttpServletResponse response, Map userRole, String method) {

        //根据用户传递的方法执行对应方法
        switch (method) {
            case "add":
                //添加
                return userServlet.addRole(userRole);
            case "get":
                //查询
                return userServlet.queryAllRole();
            case "update":
                //更新
                return userServlet.update(userRole);
            case "del":
                //删除
                return userServlet.delRole(userRole);
            default:
                return JSON.toJSONString(ResponseResult.failed("500","提交给服务器的方法错误"));
        }
    }
}
