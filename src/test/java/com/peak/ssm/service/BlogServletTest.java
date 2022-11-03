//package com.peak.ssm.service;
//
//import org.apache.ibatis.session.SqlSession;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BlogServletTest {
//
//    @Test
//    public void insertSysRoleTest3() {
//        logger.info("insertSysRoleTest3");
//
//        SqlSession sqlSession;
//
//        // 获取SqlSession
//        sqlSession = getSqlSession();
//        try {
//            // 获取RoleMapper接口
//            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            SysRole sysRole = new SysRole();
//            sysRole.setRoleName("小工匠3");
//            sysRole.setEnabled(1);
//            sysRole.setCreateBy("test3");
//            sysRole.setCreateTime(new Date());
//            // 新增用户 ,返回受影响的行数
//            int result = roleMapper.insertSysRole3(sysRole);
//
//            // 只插入一条数据 ,期望是1
//            Assert.assertEquals(1, result);
//            // 期望roleName 为小工匠
//            Assert.assertEquals("小工匠3", sysRole.getRoleName());
//
//            logger.info("sysRole:" + sysRole);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 为了保持测试数据的干净，这里选择回滚
//            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
//            // 除非显式的commit，否则不会提交到数据库
//            sqlSession.rollback();
//            logger.info("为了保持测试数据的干净，这里选择回滚,不写入mysql,请观察日志，回滚完成");
//
//            sqlSession.close();
//            logger.info("sqlSession close successfully ");
//        }
//    }
//}