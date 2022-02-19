package com.itcast.test;

import com.itcast.entity.User;
import com.itcast.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MapperTest {

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        // 关闭连接
        sqlSession.close();
    }



    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(8);
        System.out.println(user);
        // 关闭连接
        sqlSession.close();
    }


    @Test
    public void test() throws IOException {

        User user = new User();
        user.setUsername("jim");
        user.setPassword("123");
        user.setBirthday(new Date());

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        /*
            需求: 为了将Date类型转换为毫秒数存到数据库的,
            数据库中的birthday字段类型是: bigint类型. (存入的数据类型 和 Mysql数据库中的字段类型不一样, 所以就报错了)

            报错内容: Data truncated for column 'birthday' at row 1

            因此需要自定义类型转换器
         */
        userMapper.save(user);

        // 关闭连接
        sqlSession.close();
    }


}
