package com.itheima.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

import static org.junit.Assert.*;

public class JdbcTemplateTestTest {

    /*
        创建spring容器 然后执行jdbcTemplate的测试
     */
    @Test
    public void jdbcTemplateTest() {
        // 由spring容器产生JDBC模板对象 和 一些需要的Bean
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        int row = jdbcTemplate.update("INSERT INTO `account` VALUES(?,?,?)",  "0","lily", 5000);
        System.out.println(row);
    }





    /*
        测试JdbcTemplate开发步骤
     */
    @Test
    public void test() throws PropertyVetoException {
        // 创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源
        jdbcTemplate.setDataSource(dataSource);

        // 执行操作
        int row = jdbcTemplate.update("INSERT INTO `account` VALUES(?,?,?)",  "0","lily", 5000);
        System.out.println(row);

    }
}
