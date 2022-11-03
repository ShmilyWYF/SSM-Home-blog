package com.peak.ssm.service;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.dao.BlogDao;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.Friend;

import java.util.List;
import java.util.Map;

public class BlogFriendServlet {
    public static String add(Map mapdata, BlogDao dao) {
        Friend friend = new Friend();
        friend.setSiteName((String) mapdata.get("siteName"));
        friend.setPath((String) mapdata.get("path"));
        friend.setDesc((String) mapdata.get("desc"));
        int i = dao.addBlogFriend(friend);
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok(i));
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "添加失败，检查错误日志"));
        }
    }

    public static String get(Map mapdata, BlogDao dao) {
        if (mapdata.get("data").equals("null")) {
            List<Friend> list = dao.getBlogFriend();
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
        Friend friend = new Friend((Integer) mapdata.get("id"), (String) mapdata.get("siteName"), (String) mapdata.get("path"), (String) mapdata.get("desc"));
        int i = dao.updateBlogFriend(friend);
        if (i>0) {
            return JSON.toJSONString(ResponseResult.ok());
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "更新失败，检查错误日志"));
        }
    }

    public static String del(Map mapdata, BlogDao dao) {
        int i = dao.delBlogFriend((Integer) mapdata.get("id"));
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok(i,"删除成功"));
        } else {
            return JSON.toJSONString(ResponseResult.ok(null, "删除失败，检查错误日志"));
        }

    }
}
