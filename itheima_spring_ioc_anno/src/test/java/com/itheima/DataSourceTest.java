package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据源测试
 *
 * @author DELL_
 * @date 2022/02/02
 */
public class DataSourceTest {

    @Test
    public void testC3P0() throws Exception {
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


    @Test
    public void testDruid() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");

        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
        // com.mysql.jdbc.JDBC4Connection@18ef96
    }



}
