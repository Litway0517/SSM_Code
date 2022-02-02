package com.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

public class DataSourceTest {

    @Test
    // 测试数据源
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 设置四个必要参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        // 获取链接然后进行测试
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // com.mchange.v2.c3p0.impl.NewProxyConnection@5e025e70

        // 记着释放
        connection.close();
    }



}
