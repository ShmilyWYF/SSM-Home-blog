package com.peak.ssm.mapper;

import com.peak.ssm.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BlogMapper {



    @Insert("insert into t_blog(t_time,t_body) values(#{map.t_time},#{map.t_body})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int AddBlog(@Param("map") Map map);

    List<Blog> queryAllBlog();

    @Update("update t_blog set t_time=#{map.t_time},t_body=#{map.t_body}")
    int updataBlog(@Param("map") Map map);

    @Delete("delete from t_blog where  id=#{id}")
    int DelBlog(int id);

    /**----分界线-----**/

    /**friend表**/
    @Select("select * from t_friend")
    List<Friend> getBlogFriend();

    @Insert("insert t_friend values(null,#{friend.siteName},#{friend.path},#{friend.desc})")
    int addBlogFriend(@Param("friend") Friend friend);

    @Update("update t_friend set siteName=#{friend.siteName},path=#{friend.path},`desc`=#{friend.desc} where id=#{friend.id}")
    int updateBlogFriend(@Param("friend") Friend friend);

    @Delete("delete from t_friend where id=#{id}")
    int delBlogFriend(Integer id);


    /**获取博文与根据id获取博文与单表添加博文(没有与博文信息表关联)**/
    @Select("select * from t_blogweb")
    List<Blogweb> getAllfetchblogweb();

    @Select("select * from t_blogweb where id=#{id}")
    List<Blogweb> getfetchblogweb(int id);

    @Insert("insert into t_blogweb values(null,#{blogweb.title},#{blogweb.desc},#{blogweb.name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int fetchblogweb(@Param("blogweb") Blogweb blogweb);


    /**social表**/
    @Select("select * from t_social")
    List<Social> getBlogSocial();

    @Insert("insert into t_social values(0,#{social.title},#{social.icon},#{social.color},#{social.href})")
    int addBlogSocial(@Param("social") Social social);

    @Update("update t_social set title=#{social.title},icon=#{social.icon},color=#{social.color},href=#{social.href} where id=#{social.id}")
    int updateBlogSocial(@Param("social")Social social);

    @Delete("delete from t_social where id=#{id}")
    int delBlogSocial(Integer id);


    /**博客用户表**/
    @Select("select * from t_siteinfo")
    List<SiteInfo> fetchSiteInfo();

    @Update("UPDATE t_siteinfo SET avatar=#{siteInfo.avatar}, slogan=#{siteInfo.slogan}, name=#{siteInfo.name}, domain=#{siteInfo.domain}, notice=#{siteInfo.notice} where id=#{siteInfo.id}")
    int fetchSiteInfoUpdate(@Param("siteInfo") SiteInfo siteInfo);


    /**list和blogweb联表**/
    List<BlogwebFetchList> getfetchList();

    int addblogweblist(@Param("blogwebFetchList") BlogwebFetchList blogwebFetchList);

    List<BlogwebFetchList> getfetchListId(int i);

    int delblogweblist(int id);

    @Update("UPDATE t_list set  viewsCount=#{viewsCount} where id=#{id}")
    int updatafetchListId(@Param("id") int id,@Param("viewsCount") int viewsCount);


    /**focus表**/
    @Delete("delete from t_focus where id=#{id}")
    int delBlogFocus(int id);

    @Select("select * from t_focus")
     List<Focus> getBlogFocus();

    @Insert("insert into t_focus values(null,#{focus.title},#{focus.img},#{focus.href})")
    int addBlogFocus(@Param("focus") Focus focus);

    @Update("update t_focus set title=#{focus.title},img=#{focus.img},href=#{focus.href} where id=#{focus.id}")
    int updateBlogFocus(@Param("focus") Focus focus);


}
