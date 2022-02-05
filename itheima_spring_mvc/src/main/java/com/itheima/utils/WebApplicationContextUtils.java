package com.itheima.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * web应用程序上下文跑龙套
 *
 * @author DELL_
 * @date 2022/02/05
 */
public class WebApplicationContextUtils {


    public static ApplicationContext getWebApplicationContext(ServletContext servletContext) {
        return (ApplicationContext) servletContext.getAttribute("app");

    }

}
