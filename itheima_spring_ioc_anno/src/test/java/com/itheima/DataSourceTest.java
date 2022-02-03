package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

        /*
            设置上必要的连接参数, 但是这样写上的话就和源码耦合在一起了. 后期如果更换数据库则必须修改本部分的源码.
            接下来就抽取配置信息成为properties
         */
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");

        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
        // com.mysql.jdbc.JDBC4Connection@18ef96
    }


    @Test
    public void testC3P0ByProperties() throws PropertyVetoException, SQLException {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();

        // 使用ResourceBundle读取配置文件 -> ResourceBundle的基路径就是 resources 配置文件的路径
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        // 加载读取到的配置
        c3p0.setDriverClass(driver);
        c3p0.setJdbcUrl(url);
        c3p0.setUser(username);
        c3p0.setPassword(password);

        Connection connection = c3p0.getConnection();
        System.out.println(connection);
        connection.close();
    }



}
