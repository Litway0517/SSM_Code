package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.Connection;

// 加上注解 @Configuration 标名此类是Spring配置类
@Configuration

// 配置扫描组件 以及 扫描范围
// <context:component-scan base-package="com.itheima" />
@ComponentScan("com.itheima")

// 加载配置文件
// <context:property-placeholder location="classpath:jdbc.properties" />
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {


    // 使用普通数据注入的方式
    // 使用spEL表达式获取配置文件中的参数配置
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;



    // spring会将当前方法的返回值以指定名称存储到spring容器中
    @Bean("dataSource")
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();

        c3p0.setDriverClass(driver);
        c3p0.setJdbcUrl(url);
        c3p0.setUser(username);
        c3p0.setPassword(password);

        Connection connection = c3p0.getConnection();
        System.out.println(connection);
        connection.close();

        return (DataSource) connection;
    }



}
