package com.peak.ssm.service;

import com.alibaba.fastjson.JSON;
import com.peak.ssm.dao.UserDao;
import com.peak.ssm.httpUiltr.ResponseResult;
import com.peak.ssm.pojo.LoginRoles;
import com.peak.ssm.pojo.LoginUser;
import com.peak.ssm.pojo.UserRole;
import com.peak.ssm.pojo.Userinfo;
import com.peak.ssm.uiltr.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.*;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class UserServlet extends HttpServlet{

    @Autowired
    private UserDao userDao;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public String Roleslogin(String username, String password){
        List<LoginUser> list = userDao.getUserName(username);
        if (list.size() > 0) {
            for (LoginUser key : list) {
                //判断用户密码
                if(key.getPassword().equals(password)){
                    //设置cookie
                    Cookie cookieName=new Cookie("username",key.getUsername());
                    Cookie cookiePaw=new Cookie("password",key.getPassword());
                    try {
                        CookieUtilr.setCookie(request,response,cookieName,cookiePaw);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    //按主键（ID）查询角色
                    List<Userinfo> userinfo = userDao.selectRoleByPrimaryKey(key.getId());

                    //设置token
                    TokenTools.createToken(request,"token");

                    //设置用户token 加入缓存 解析查询到的角色 加入缓存 缓存为用户token
                    RolesParseUtilr.rolesparse(request,userinfo);

                    int id = key.getId();

                    Map map=new HashMap();
                    map.put("token",request.getSession().getAttribute("token"));
                    map.put("id",id);

                    //根据名称判断返回用户信息
                    return JSON.toJSONString(ResponseResult.ok(map));
                }else {
                    //密码错误
                    return JSON.toJSONString(ResponseResult.failed(501,"密码错误"));
                }
            }
        } else {
            //用户不存在
            return JSON.toJSONString(ResponseResult.failed(503,"用户不存在"));
        }
        return null;
    }

    //需要解决浏览器跨域导致session丢失问题
    @CrossOrigin
    public String Rolesinfo() {
//        String id = request.getParameter("id");
//        List<Userinfo> userinfo = userDao.selectRoleByPrimaryKey(Integer.parseInt(id));
//        Map map = (Map) JSON.parse(JSON.toJSONString(userinfo.get(0).getLoginRoles()));
//        LoginRoles loginRoles = new LoginRoles();
//        loginRoles.setName(map.get("name"));
//        loginRoles.setAvatar(map.get("avatar"));
//        loginRoles.setIntroduction(map.get("introduction"));
//        loginRoles.setRoles(new Object[]{map.get("role")});
//        if (!id.equals("")) {
//            return JSON.toJSONString(ResponseResult.ok(loginRoles));
//        } else {
//            return JSON.toJSONString(ResponseResult.failed(515, "token已失效"));
//        }

        if(TokenTools.judgeTokenIsEqual(request,"token","token")){
                //根据token找到角色信息缓存
            return JSON.toJSONString(
                    ResponseResult.ok(
                        SessionTools.getSession(request, (String) request.getSession().getAttribute("token"))
            )
            );
        }else {
            return JSON.toJSONString(ResponseResult.failed(515,"token已失效"));
        }
    }


    public String Rolesremove(){
        TokenTools.removeToken(request,"token");
        TokenTools.removeToken(request,request.getParameter("token"));
        return JSON.toJSONString(ResponseResult.ok("退出成功"));
    }

    /**登录处理类**/
    public String queryAllRole() {
        List<UserRole> roles=userDao.selectAllRole();
        return JSON.toJSONString(ResponseResult.ok(roles));
    }

    public String addRole(Map userRole) {
        UserRole userRoles=new UserRole();
        userRoles.setUsername((String) userRole.get("username"));
        userRoles.setPassword((String) userRole.get("password"));
        userRoles.setName((String) userRole.get("name"));
        userRoles.setAvatar((String) userRole.get("avatar"));
        userRoles.setIntroduction((String) userRole.get("introduction"));
        userRoles.setRole(JSON.toJSONString(userRole.get("role")));

        int i=userDao.addRole(userRoles);

        if(i>0){
            return JSON.toJSONString(ResponseResult.ok());
        }else {
            return JSON.toJSONString(ResponseResult.failed("添加失败"));
        }
    }


    public String update(Map userRole) {

        UserRole userRoles=new UserRole();
        userRoles.setId((Integer) userRole.get("id"));
        userRoles.setUsername((String) userRole.get("username"));
        userRoles.setPassword((String) userRole.get("password"));
        userRoles.setName((String) userRole.get("name"));
        userRoles.setAvatar((String) userRole.get("avatar"));
        userRoles.setIntroduction((String) userRole.get("introduction"));
        userRoles.setRole(JSON.toJSONString(userRole.get("role")));

        int i=userDao.updateRole(userRoles);

        if(i>0){
            return JSON.toJSONString(ResponseResult.ok());
        }else {
            return JSON.toJSONString(ResponseResult.failed("更新失败"));
        }
    }

    public String delRole(Map userRole) {
        int id =(Integer) userRole.get("id");
        int i=userDao.delRole(id);
        if(i>0){
            return JSON.toJSONString(ResponseResult.ok());
        }else {
            return JSON.toJSONString(ResponseResult.failed("删除失败"));
        }
    }
}
