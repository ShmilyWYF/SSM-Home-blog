package com.peak.ssm.service;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.dao.BlogDao;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.BlogwebFetchList;
import com.peak.ssm.pojo.FetchList;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BlogListServlet {


    public static String add(Map data, BlogDao dao) {
        FetchList fetchList = new FetchList();
        fetchList.setTop((boolean) data.get("isTop"));
        fetchList.setBanner((String) data.get("banner"));
        fetchList.setHot((boolean) data.get("isHot"));
        fetchList.setPubTime(new Date());
        fetchList.setTitle((String) data.get("title"));
        fetchList.setSummary((String) data.get("summary"));
        fetchList.setViewsCount((int) data.get("viewsCount"));
        BlogwebFetchList blogwebFetchList = new BlogwebFetchList(0, (String) data.get("title"), (String) data.get("desc"), (String) data.get("name"), fetchList);
        int i = dao.addblogweblist(blogwebFetchList);
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok(i));
        } else {
            return JSON.toJSONString(ResponseResult.failed(i));
        }
    }

    public static String get(Map data, BlogDao dao) {

        if (data.get("data").equals("null")) {
            List<BlogwebFetchList> blogwebs = dao.getfetchList();
            if (blogwebs.size() > 0) {
                return JSON.toJSONString(ResponseResult.ok(blogwebs));
            } else {
                return JSON.toJSONString(ResponseResult.ok(null, "没有找到任何数据"));
            }
        } else if (data.containsKey("page")) {

            //<!--1:1-10 2:11-20 slice((当前页数-1)*每页条数，当前页数*当前条数)-->
            //(currentPage-1)*pageSize,currentPage*pageSize)
            // currentPage:1,  当前页数
            // pageSize:10,    每一页显示条数
            // total:0,        总条数

            //获取后端数据
            List<BlogwebFetchList> obj = dao.getfetchList();
            List<FetchList> list = new ArrayList<>();
            //循环结果集
            for (BlogwebFetchList key : obj) {
                //将结果集中fetchlist赋值给新集合
                list.add(key.getFetchList());
            }
            //当前页
            int param = (int) data.get("page");   //默认为1  第一页
            List<FetchList> fetchLists = new ArrayList<>();
            try {
                for (int i = param - 1; i < param + 1; i++) {
                    fetchLists.add(list.get(i));
                }
            } catch (Exception e) {        //如果数据只有一条 抛出异常
                e.printStackTrace();
            }
            //构建返回结果对象
            Map<String, Object> maps = new HashMap();
            maps.put("total", obj.size());   //总条数
            maps.put("items", fetchLists);
            maps.put("hasNextPage", (param * 2) < obj.size()); //是否有下一页
            maps.put("page", param);
            maps.put("size", param + 1);
            if (obj.size() > 0) {
                return JSON.toJSONString(ResponseResult.ok(maps));
            } else {
                return JSON.toJSONString(ResponseResult.ok("没有发布任何文章"));
            }
        } else {
            int i=Integer.parseInt(data.get("id").toString());
            //根据id获取
            List<BlogwebFetchList> blogwebFetchLists = dao.getfetchListId(i);
            if (blogwebFetchLists.size() > 0) {
                return JSON.toJSONString(ResponseResult.ok(blogwebFetchLists));
            } else {
                return JSON.toJSONString(ResponseResult.failed(null,"没有找到文章"));
            }
        }
    }
    public static String updata(Map data, BlogDao dao) {
        int id=Integer.parseInt(data.get("id").toString());
        int viewsCount=Integer.parseInt(data.get("viewsCount").toString());
        int updata = dao.updatafetchListId(id,viewsCount);
        if (updata> 0) {
            return JSON.toJSONString(ResponseResult.ok(updata));
        } else {
            return JSON.toJSONString(ResponseResult.failed(null,"没有找到文章"));
        }
//        int i=Integer.parseInt(data.get("id").toString());
//        List<BlogwebFetchList> updata = dao.updatafetchListId(i);
//        if (updata.size() > 0) {
//            return JSON.toJSONString(ResponseResult.ok(updata));
//        } else {
//            return JSON.toJSONString(ResponseResult.failed(null,"没有找到文章"));
//        }
    }

    public static String del(Map data, BlogDao dao) {
        int i = dao.delblogweblist((Integer) data.get("id"));
        if (i > 0) {
            return JSON.toJSONString(ResponseResult.ok(i,"删除成功"));
        } else {
            return JSON.toJSONString(ResponseResult.failed(null,"删除失败"));
        }
    }

}


