package com.itheima.test;

import com.itheima.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {



    @Test
    public void findAll() throws IOException {

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数: namespace + id
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        System.out.println(userList);


        // 释放资源
        sqlSession.close();
    }



}
