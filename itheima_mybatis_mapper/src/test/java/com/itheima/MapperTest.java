package com.itheima;

import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 映射器测试
 *
 * @author DELL_
 * @date 2022/02/27
 */
public class MapperTest {

    @Test
    public void test() throws IOException {

        User user = new User();
        user.setId(4);
//        user.setUsername("zhangsan");
//        user.setPassword("123");


        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        ids.add(9);

        List<User> userList = userMapper.findByIds(ids);
        System.out.println(userList);

        // 关闭连接
        sqlSession.close();


    }



}
