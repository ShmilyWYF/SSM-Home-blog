package com.peak.ssm.service;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.dao.BlogDao;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@Service
public class BlogServlet {

    @Autowired
    private BlogDao dao;
    @Autowired
    HttpServletRequest request;


    public String addBlog() {
        Map map = (Map) JSON.parse(request.getParameter("data"));
        int i = dao.addBlog(map);
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.failed());
        }
    }

    public String getAllBlog() {
        List<Blog> blogs = dao.queryAllBlog();
        if (blogs.size() > 0) {
            return JSON.toJSONString(ResponseResult.ok(blogs));
        } else {
            return JSON.toJSONString(ResponseResult.ok(null,"没有任何信息"));
        }
    }

    public String updataBlog() {
        Map map = (Map) JSON.parse(request.getParameter("data"));
        int i = dao.updataBlog(map);
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.failed());
        }
    }

    public String DelBlog() {
        Map map = (Map) JSON.parse(request.getParameter("data"));
        int i = dao.DelBlog((Integer)map.get("id"));
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.failed());
        }
    }

    /**---首页用户表-分界线---**/

    //获取站点管理员信息
    public String fetchSiteInfogetAll() {
        List<SiteInfo> list = dao.fetchSiteInfo();
        return JSON.toJSONString(ResponseResult.ok(list));
    }

    //修改管理员信息
    public String fetchSiteInfoUpdate() {
        Map map = (Map) JSON.parse(request.getParameter("userinfo"));

        SiteInfo siteInfo = new SiteInfo();
        siteInfo.setId((int) map.get("id"));
        siteInfo.setName((String) map.get("name"));
        siteInfo.setAvatar((String) map.get("avatar"));
        siteInfo.setDomain((String) map.get("domain"));
        siteInfo.setNotice((String) map.get("notice"));
        siteInfo.setSlogan((String) map.get("slogan"));

        int list = dao.fetchSiteInfoUpdate(siteInfo);
        if(list>0){
            return JSON.toJSONString(ResponseResult.ok(list,"更新成功"));
        }else {
            return JSON.toJSONString(ResponseResult.failed(list,"更新失败"));
        }
    }

    //获取我的社交信息
    public String fetchSocial() {
        String data = request.getParameter("data");
        String method = request.getParameter("method");
        Map mapdata = new HashMap();
        if(data.equals("null")){
            mapdata.put("data","null");
        }else {
            try {
                String str1= URLDecoder.decode(data, "UTF-8");
                mapdata=(Map)JSON.parse(str1);
                mapdata.put("data",str1);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        switch (method){
            case "add":
                return BlogSocialServlet.add(mapdata,dao);
            case "get":
                return BlogSocialServlet.get(mapdata,dao);
            case "update":
                return BlogSocialServlet.update(mapdata,dao);
            case "del":
                return BlogSocialServlet.del(mapdata,dao);
            default:
                return JSON.toJSONString(ResponseResult.failed());
        }
    }

    //获取文章和卡片 文章管理列表
    public String fetchList() {
        String data = request.getParameter("data");
        String method = request.getParameter("method");

        Map mapdata = new HashMap();
        if(data.equals("null")){
            mapdata.put("data","null");
        }else {
            try {
                String str1= URLDecoder.decode(data, "UTF-8");
                mapdata=(Map)JSON.parse(str1);
                mapdata.put("data",str1);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        switch (method){
            case "add":
                return BlogListServlet.add(mapdata,dao);
            case "get":
                return BlogListServlet.get(mapdata,dao);
            case "updata":
                return BlogListServlet.updata(mapdata,dao);
            case "del":
                return BlogListServlet.del(mapdata,dao);
            default:
                return JSON.toJSONString(ResponseResult.failed());
        }
    }

    //获取焦点（广告位/跳转链接位置）
    public String fetchFocus() {
        String data = request.getParameter("data");
        String method = request.getParameter("method");
        Map mapdata = new HashMap();
        if(data.equals("null")){
            mapdata.put("data","null");
        }else {
            try {
                String str1= URLDecoder.decode(data, "UTF-8");
                mapdata=(Map)JSON.parse(str1);
                mapdata.put("data",str1);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        switch (method){
            case "add":
                return BlogFocusServlet.add(mapdata,dao);
            case "get":
                return BlogFocusServlet.get(mapdata,dao);
            case "updata":
                return BlogFocusServlet.updata(mapdata,dao);
            case "del":
                return BlogFocusServlet.del(mapdata,dao);
            default:
                return JSON.toJSONString(ResponseResult.failed());
        }
    }

    //友链
    public String fetchFriend() {
        String data = request.getParameter("data");
        String method = request.getParameter("method");

        Map mapdata = new HashMap();
        if(data.equals("null")){
            mapdata.put("data","null");
        }else {
            try {
                String str1= URLDecoder.decode(data, "UTF-8");
                mapdata=(Map)JSON.parse(str1);
                mapdata.put("data",str1);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        switch (method){
            case "add":
                return BlogFriendServlet.add(mapdata,dao);
            case "get":
                return BlogFriendServlet.get(mapdata,dao);
            case "updata":
                return BlogFriendServlet.update(mapdata,dao);
            case "del":
                return BlogFriendServlet.del(mapdata,dao);
            default:
                return JSON.toJSONString(ResponseResult.failed());
        }
    }

    //单独获取博文
    public String fetchblogweb() {
        String form = request.getParameter("data");
        Map map= (Map) JSON.parse(form);
        Blogweb blogweb=new Blogweb();
        blogweb.setTitle((String) map.get("title"));
        blogweb.setDesc((String) map.get("desc"));
        blogweb.setName((String) map.get("name"));
        int i = dao.fetchblogweb(blogweb);
        if(i>0){
            return JSON.toJSONString(ResponseResult.ok(i));
        }else {
            return JSON.toJSONString(ResponseResult.failed());
        }
    }

}
