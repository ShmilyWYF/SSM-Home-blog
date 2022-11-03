package com.peak.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.Blog;
import com.peak.ssm.pojo.LoginUser;
import com.peak.ssm.pojo.UserRole;
import com.peak.ssm.uiltr.IndexMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Controller
public class ControllerView {
    @Autowired
    private IndexMethod indexMethod;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("urlval", "home");
        return "home";
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public String one(Model model) {
        model.addAttribute("urlval", "one");
        return "home";
    }


    @CrossOrigin
    @RequestMapping("/blogindex")
    public String blogindx(){
        return "dist";
    }

    @CrossOrigin
    @RequestMapping("/login")
    public String login(){
        return "dist";
    }

    @CrossOrigin
    @RequestMapping("/404")
    public String errer(){
        return "404";
    }

    /***控制中心已经登录页转发
     *     @RequestMapping(value = {"/controller",}, method = RequestMethod.GET)
     *     public String controllercenter(HttpServletResponse response, HttpServletRequest request, Model model) {
     *         try {
     *             Map map = CookieUtilr.getCookie(request, response);
     *             JSONObject json = new JSONObject(map);
     *             model.addAttribute("user", json);
     *         } catch (ServletException | IOException e) {
     *             e.printStackTrace();
     *         }
     *         return "controller";
     *     }
     */


    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = {"/dispatcher/blog"}, method = {RequestMethod.POST,RequestMethod.GET})
    public void blog(){
        try {
            response.getWriter().append(indexMethod.isMethod(request, response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user/login", method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.OPTIONS})
    public void login(@RequestBody(required = false) LoginUser user) {
        try {
            response.getWriter().append(indexMethod.isMethod(request, response, user));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user/{method}",method = {RequestMethod.GET,RequestMethod.POST})
    public void userNameRole(@PathVariable("method") String method,@RequestBody(required = false) Map userRole){
        try {
                response.getWriter().append(indexMethod.isMethod(request, response, userRole,method));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user/apiExtNews/list", method = RequestMethod.POST)
    public void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().append(JSON.toJSONString(new ResponseResult("true", 200, "查找个寂寞")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

