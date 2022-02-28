package com.itheima.test;

import com.itheima.entity.Order;
import com.itheima.entity.User;
import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MultiTest {


    // 多对多 -> 一个用户可能有多个角色. 同时一个角色也能够被多个用户所标识.
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allUserAndRole = mapper.findAllUserAndRole();
        for (User user : allUserAndRole) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    // 一对多. 一个用户可能会有多个订单.
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }


    // 一对一 -> 一个订单仅仅是一个用户的.
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得MyBatis框架生成的UserMapper接口的实现类
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = mapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }

        sqlSession.close();

    }


}
