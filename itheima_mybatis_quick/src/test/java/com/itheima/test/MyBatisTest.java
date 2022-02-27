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

/**
 * mybatis测试
 *
 * @author DELL_
 * @date 2022/02/26
 */
public class MyBatisTest {

    // 根据id查找用户
    @Test
    public void findById() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数: namespace + id
        User user = sqlSession.selectOne("userMapper.findById", 5);

        System.out.println(user);

        // 释放资源
        sqlSession.close();
    }

    // 根据id删除用户
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


    // 更新用户, 需要传入参数user
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


    // 插入用户, 传入一个user对象
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

        // mybatis的事务默认是关闭的, 也就是说, 当有数据更新的时候, 需要手动提交. 但是参数设置为true会自动提交
        sqlSession.commit(true);

        System.out.println(insert);

        // 释放资源
        sqlSession.close();
    }

    // 查询所有用户信息
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
