package com.itheima.service;


import com.itheima.dao.UserMapper;
import com.itheima.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 服务演示
 *
 * @author DELL_
 * @date 2022/02/27
 */
public class ServiceDemo {

    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 获取实现类Mapper代理对象(这是MyBatis动态代理事项的)
        List<User> userList = userMapper.findAll();
        System.out.println(userList);

        // 根据Id查询
        User user = userMapper.findById(7);
        System.out.println(user);

        // 关闭连接
        sqlSession.close();

    }

}
