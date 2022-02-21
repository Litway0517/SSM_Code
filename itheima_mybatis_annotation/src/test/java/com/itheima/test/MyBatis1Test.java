package com.itheima.test;

import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatis1Test {

    private UserMapper userMapper;

    // @Before注解: 表示下面的测试方法执行之前会先执行这个方法
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");
        user.setBirthday(new Date());
        userMapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(14);
        user.setUsername("lihua");
        user.setPassword("123");
        user.setBirthday(new Date());
        userMapper.update(user);
    }

    @Test
    public void testDelete() {
        userMapper.delete(13);
    }

    @Test
    public void testFindById() {
        User user = userMapper.findById(10);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }




}
