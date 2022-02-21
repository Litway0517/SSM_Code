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
import java.util.List;

public class MyBatis4Test {

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
    public void test() {
        List<User> userAndRoleAll = userMapper.findUserAndRoleAll();
        for (User user : userAndRoleAll) {
            System.out.println(user);
        }
    }







}
