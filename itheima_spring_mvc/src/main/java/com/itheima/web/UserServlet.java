package com.itheima.web;


import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户servlet
 *
 * @author DELL_
 * @date 2022/02/04
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 最原始的方法
        // ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        ServletContext servletContext = req.getServletContext();

        // 直接使用工具类取出spring容器, 而不需要记住名称.
        // ApplicationContext app = (ClassPathXmlApplicationContext) servletContext.getAttribute("app");

        // 这个是手动封装的工具. 但是spring-web已经集成了改工具. 因此直接用就好了
        // ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        // spring-web中的工具包
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserServiceImpl userServiceImpl = app.getBean(UserServiceImpl.class);
        userServiceImpl.save();

    }
}
