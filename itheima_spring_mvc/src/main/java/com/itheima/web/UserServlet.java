package com.itheima.web;


import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.WebApplicationContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ServletContext servletContext = req.getServletContext();

        // 直接使用工具类取出spring容器, 而不需要记住名称.
        // ApplicationContext app = (ClassPathXmlApplicationContext) servletContext.getAttribute("app");

        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserServiceImpl userServiceImpl = app.getBean(UserServiceImpl.class);
        userServiceImpl.save();

    }
}
