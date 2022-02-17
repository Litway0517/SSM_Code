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
    public void delete() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数: namespace + id. 这里面给user实体也可以
        int delete = sqlSession.delete("userMapper.delete", 1);

        // mybatis的事务默认是关闭的, 也就是说, 当有数据更新的时候, 需要手动提交
        sqlSession.commit();

        System.out.println(delete);

        // 释放资源
        sqlSession.close();
    }



    @Test
    public void update() throws IOException {
        User user = new User();
        user.setId(11);
        user.setUsername("lucy");
        user.setPassword("5678");

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数: namespace + id. 后面还需要给予插入的实体
        int update = sqlSession.update("userMapper.update", user);

        // mybatis的事务默认是关闭的, 也就是说, 当有数据更新的时候, 需要手动提交
        sqlSession.commit();

        System.out.println(update);

        // 释放资源
        sqlSession.close();
    }



    @Test
    public void save() throws IOException {
        User user = new User();
        user.setUsername("alien");
        user.setPassword("5678");

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数: namespace + id. 后面还需要给予插入的实体
        int insert = sqlSession.insert("userMapper.save", user);

        // mybatis的事务默认是关闭的, 也就是说, 当有数据更新的时候, 需要手动提交
        sqlSession.commit();

        System.out.println(insert);

        // 释放资源
        sqlSession.close();
    }


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