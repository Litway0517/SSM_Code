package com.itheima.config;

import org.springframework.context.annotation.*;


/**
 * spring配置
 *
 * @author DELL_
 * @date 2022/02/04
 */

// 加上注解 @Configuration 标识此类是Spring容器的核心配置类
@Configuration

// 配置扫描组件 以及 扫描范围
// <context:component-scan base-package="com.itheima" />
@ComponentScan("com.itheima")

// 加载分配置文件
// <import resource="" />
@Import({DataSourceConfiguration.class})    // 参数是一个数组, 可以传递多个配置文件类

public class SpringConfiguration {





}
