package com.chen.test;

import com.chen.Mapper.UserMapper;
import com.chen.po.Course;
import com.chen.po.User;
import com.chen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.List;


public class UserCourseTest {

    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        System.out.println("(u_id="+user.getU_id()+", "+"userName="+user.getUserName()+", "+"corp="+user.getCorp()+")");
        List<Course> courseList = user.getCourses();
        for (Course course : courseList) {
            System.out.println("\t"+"(course="+course.getCourseName()+", "+"teacher="+course.getTeacher().getTeacherName()+")");
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }
    @Test
    public void selectAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println("(u_id="+user.getU_id()+", "+"userName="+user.getUserName()+", "+"corp="+user.getCorp()+")");
            List<Course> courseList = user.getCourses();
            for (Course course : courseList) {
                System.out.println("\t"+course);
            }
        }
    }
    @Test
    public void selectAllLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int pageNumber=2;
        int pageSize=3;
        int start=(pageNumber-1)*pageSize;
        List<User> userList = userMapper.findAllLimit(start,pageSize);
        for (User user : userList) {
            System.out.println("(u_id="+user.getU_id()+", "+"userName="+user.getUserName()+", "+"corp="+user.getCorp()+")");
            List<Course> courseList = user.getCourses();
            for (Course course : courseList) {
                System.out.println("\t"+"(course="+course.getCourseName()+", "+"teacher="+course.getTeacher().getTeacherName()+")");
            }
        }
    }
    @Test
    public void testAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user.getUserName());
            List<Course> courseList = user.getCourses();
            for (Course course : courseList) {
                System.out.println("\t"+course);
            }
        }
    }
}
