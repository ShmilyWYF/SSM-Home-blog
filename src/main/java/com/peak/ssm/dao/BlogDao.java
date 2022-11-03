package com.peak.ssm.dao;

import com.peak.ssm.pojo.*;

import java.util.List;
import java.util.Map;

public interface BlogDao {

    List<Blog> queryAllBlog();

    int addBlog(Map blog);

    List<Social> getBlogSocial();

    List<Focus> getBlogFocus();

    List<SiteInfo> fetchSiteInfo();

    int fetchSiteInfoUpdate(SiteInfo siteInfo);

    int fetchblogweb(Blogweb blogweb);


    int addblogweblist(BlogwebFetchList blogwebFetchList);

    int delblogweblist(int id);

    List<BlogwebFetchList> getfetchList();

    int delBlogFocus(int id);

    int addBlogFocus(Focus focus);

    List<BlogwebFetchList> getfetchListId(int i);

    int updateBlogFocus(Focus focus);

    int addBlogSocial(Social social);

    int updateBlogSocial(Social social);

    int delBlogSocial(Integer id);

    int addBlogFriend(Friend friend);

    List<Friend> getBlogFriend();

    int updateBlogFriend(Friend friend);

    int delBlogFriend(Integer id);

    int updatafetchListId(int id, int viewsCount);

    int updataBlog(Map map);

    int DelBlog(int id);
}
