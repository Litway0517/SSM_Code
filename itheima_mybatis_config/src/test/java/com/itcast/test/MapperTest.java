package com.itcast.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

/**
 * 映射器测试
 *
 * @author DELL_
 * @date 2022/02/27
 */
public class MapperTest {

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 设置分页数据. 当前页码号+每一页显示的条数. 即, 第五页, 每页三条 -> 最后得到的是13, 14, 15这三条数据
        // (PageNo - 1) * PageSize + 1  (页码号 - 1) * 页码大小 + 1
        PageHelper.startPage(3, 3);

        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        /*
            获取与分页相关的参数 -> 需要将上面查询出来的结果作为参数传入PageInfo的构造方法中
            这个是根据上面的查询到的结果进行推算的.
            当前页码, 其实就是上面传递的参数 = 2
            页面大小, 就是每页显示几条(最后一页除外) 上面的参数 = 3

            总条数, 在查询的时候就查出来了, 只不过没显示
            总页数, 根据页面大小 和 总条数 进行计算. 总页数 = 总条数 / 页面大小 + 1
            上一页下一页也好算.
         */
        PageInfo<User> userPageInfo = new PageInfo<User>(userList);
        System.out.println("当前页码: " + userPageInfo.getPageNum());
        System.out.println("每页显示的条数: " + userPageInfo.getPageSize());

        System.out.println("总条数: " + userPageInfo.getTotal());
        System.out.println("总页数: " + userPageInfo.getPages());
        System.out.println("上一页: " + userPageInfo.getPrePage());
        System.out.println("下一页: " + userPageInfo.getNextPage());

        System.out.println("是否是第一页: " + userPageInfo.isIsFirstPage());
        System.out.println("是否是最后一页: " + userPageInfo.isIsLastPage());

        System.out.println("直接输出PageInfo: " + userPageInfo);


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

            因此需要自定义类型转换器DateHandler(继承自BaseTypeHandler<Date>)
         */
        userMapper.save(user);

        // 关闭连接
        sqlSession.close();
    }


}
