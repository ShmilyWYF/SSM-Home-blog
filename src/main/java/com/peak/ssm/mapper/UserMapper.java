package com.peak.ssm.mapper;

import com.peak.ssm.pojo.LoginUser;
import com.peak.ssm.pojo.UserRole;
import com.peak.ssm.pojo.Userinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;


public interface UserMapper {

    List<Userinfo> selectRoleByPrimaryKey(@Param("id") int id);

    List<LoginUser> getUserName(@Param("username") String username);

    List<UserRole> selectAllRole();

    int addRole(@Param("userRole") UserRole userRole);

    int delRole(int id);

    int updateRole(@Param("userRole") UserRole userRole);
}
