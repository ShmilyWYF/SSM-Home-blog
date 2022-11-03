package com.peak.ssm.dao;

import com.peak.ssm.pojo.LoginUser;
import com.peak.ssm.pojo.UserRole;
import com.peak.ssm.pojo.Userinfo;

import java.util.List;

public interface UserDao {

     List<Userinfo> selectRoleByPrimaryKey(int id);

     List<LoginUser> getUserName(String username);

     List<UserRole> selectAllRole();

     int addRole(UserRole userRole);

     int delRole(int id);

     int updateRole(UserRole userRoles);
}
