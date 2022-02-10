package com.itheima.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

import static org.junit.Assert.*;

public class JdbcTemplateTestTest {

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
        int row = jdbcTemplate.update("INSERT INTO `account` VALUES(?,?)", "tom", 5000);
        System.out.println(row);

    }
}
