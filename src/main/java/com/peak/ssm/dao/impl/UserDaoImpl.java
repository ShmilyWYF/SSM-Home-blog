package com.peak.ssm.dao.impl;

import com.peak.ssm.dao.UserDao;
import com.peak.ssm.mapper.UserMapper;
import com.peak.ssm.pojo.LoginUser;
import com.peak.ssm.pojo.UserRole;
import com.peak.ssm.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public List<Userinfo> selectRoleByPrimaryKey(int id) {
        return userMapper.selectRoleByPrimaryKey(id);
    }

    @Override
    public List<LoginUser> getUserName(String username){
        return userMapper.getUserName(username);
    }

    @Override
    public List<UserRole> selectAllRole() {
        return userMapper.selectAllRole();
    }

    @Override
    public int addRole(UserRole userRole) {
        return userMapper.addRole(userRole);
    }

    @Override
    public int delRole(int id) {
        return userMapper.delRole(id);
    }

    @Override
    public int updateRole(UserRole userRoles) {
        return userMapper.updateRole(userRoles);
    }

}
