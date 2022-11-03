package com.peak.ssm.dao.impl;

import com.peak.ssm.dao.BlogDao;
import com.peak.ssm.mapper.BlogMapper;
import com.peak.ssm.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BlogDaoImpl implements BlogDao {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> queryAllBlog() {
        return blogMapper.queryAllBlog();
    }

    @Override
    public int addBlog(Map blog) {
        return blogMapper.AddBlog(blog);
    }

    @Override
    public List<Social> getBlogSocial() {
        return blogMapper.getBlogSocial();
    }

    @Override
    public List<Focus> getBlogFocus() {
        return blogMapper.getBlogFocus();
    }

    @Override
    public List<SiteInfo> fetchSiteInfo() {
        return blogMapper.fetchSiteInfo();
    }

    @Override
    public int fetchSiteInfoUpdate(SiteInfo siteInfo) {
        return blogMapper.fetchSiteInfoUpdate(siteInfo);
    }


    @Override
    public int fetchblogweb(Blogweb blogweb) {
        return blogMapper.fetchblogweb(blogweb);
    }

    @Override
    public List<BlogwebFetchList> getfetchList() {
        return blogMapper.getfetchList();
    }

    @Override
    public int delBlogFocus(int id) {
        return blogMapper.delBlogFocus(id);
    }

    @Override
    public int addBlogFocus(Focus focus) {
        return blogMapper.addBlogFocus(focus);
    }

    @Override
    public List<BlogwebFetchList> getfetchListId(int i) {
        return blogMapper.getfetchListId(i);
    }

    @Override
    public int updateBlogFocus(Focus focus) {
        return blogMapper.updateBlogFocus(focus);
    }

    @Override
    public int addBlogSocial(Social social) {
        return blogMapper.addBlogSocial(social);
    }

    @Override
    public int updateBlogSocial(Social social) {
        return blogMapper.updateBlogSocial(social);
    }

    @Override
    public int delBlogSocial(Integer id) {
        return blogMapper.delBlogSocial(id);
    }

    @Override
    public int addBlogFriend(Friend friend) {
        return blogMapper.addBlogFriend(friend);
    }

    @Override
    public List<Friend> getBlogFriend() {
        return blogMapper.getBlogFriend();
    }

    @Override
    public int updateBlogFriend(Friend friend) {
        return blogMapper.updateBlogFriend(friend);
    }

    @Override
    public int delBlogFriend(Integer id) {
        return blogMapper.delBlogFriend(id);
    }

    @Override
    public int updatafetchListId(int id, int viewsCount) {
        return blogMapper.updatafetchListId(id,viewsCount);
    }

    @Override
    public int updataBlog(Map map) {
        return blogMapper.updataBlog(map);
    }

    @Override
    public int DelBlog(int id) {
        return blogMapper.DelBlog(id);
    }

    @Override
    public int addblogweblist(BlogwebFetchList blogwebFetchList) {
        return blogMapper.addblogweblist(blogwebFetchList);
    }

    @Override
    public int delblogweblist(int id) {
        return blogMapper.delblogweblist(id);
    }


}
