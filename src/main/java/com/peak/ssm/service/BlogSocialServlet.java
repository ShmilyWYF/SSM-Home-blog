package com.peak.ssm.service;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.dao.BlogDao;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.Focus;
import com.peak.ssm.pojo.Social;

import java.util.List;
import java.util.Map;

public class BlogSocialServlet {
    public static String add(Map mapdata, BlogDao dao) {
        Social social=new Social();
        social.setTitle((String) mapdata.get("title"));
        social.setHref((String) mapdata.get("href"));
        social.setColor((String) mapdata.get("color"));
        social.setIcon((String) mapdata.get("icon"));
        int i = dao.addBlogSocial(social);
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok(i));
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "添加失败，检查错误日志"));
        }
    }

    public static String get(Map mapdata, BlogDao dao) {
        if (mapdata.get("data").equals("null")) {
            List<Social> list = dao.getBlogSocial();
            if (list.size() > 0) {
                return JSON.toJSONString(ResponseResult.ok(list));
            } else {
                return JSON.toJSONString(ResponseResult.ok(null, "没有任何信息"));
            }
        } else {
            return JSON.toJSONString(ResponseResult.failed("获取失败，检查错误日志"));
        }
    }

    public static String update(Map mapdata, BlogDao dao) {
        Social social = new Social((Integer) mapdata.get("id"), (String) mapdata.get("title"), (String) mapdata.get("icon"), (String) mapdata.get("color"), (String) mapdata.get("href"));
        int i = dao.updateBlogSocial(social);
        if (i>0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "删除失败，检查错误日志"));
        }
    }

    public static String del(Map mapdata, BlogDao dao) {
        int i = dao.delBlogSocial((Integer) mapdata.get("id"));
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "删除失败，检查错误日志"));
        }
    }
}
