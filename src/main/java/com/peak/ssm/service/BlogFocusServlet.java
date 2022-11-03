package com.peak.ssm.service;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.dao.BlogDao;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.Focus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

public class BlogFocusServlet {

    public static String add(Map mapdata, BlogDao dao) {
        Focus focus = new Focus();
        focus.setTitle((String) mapdata.get("title"));
        focus.setImg((String) mapdata.get("img"));
        focus.setHref((String) mapdata.get("href"));
        int i = dao.addBlogFocus(focus);
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok(i));
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "添加失败，检查错误日志"));
        }
    }



    public static String get(Map mapdata, BlogDao dao) {
        if (mapdata.get("data").equals("null")) {
            List<Focus> list = dao.getBlogFocus();
            if (list.size() > 0) {
                return JSON.toJSONString(ResponseResult.ok(list));
            } else {
                return JSON.toJSONString(ResponseResult.ok(null, "没有任何信息"));
            }
        } else {
            return JSON.toJSONString(ResponseResult.failed("获取失败，检查错误日志"));
        }
    }

    public static String updata(Map mapdata, BlogDao dao) {
        Focus focus = new Focus((Integer) mapdata.get("id"), (String) mapdata.get("title"), (String) mapdata.get("img"), (String) mapdata.get("href"));
        int i = dao.updateBlogFocus(focus);
        if (i>0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "更新失败，检查错误日志"));
        }
    }

    public static String del(Map mapdata, BlogDao dao) {
        int i = dao.delBlogFocus((Integer) mapdata.get("id"));
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "删除失败，检查错误日志"));
        }

    }

}
