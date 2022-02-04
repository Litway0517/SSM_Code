package com.itheima.web;


import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext();
        UserServiceImpl userServiceImpl = app.getBean(UserServiceImpl.class);
        userServiceImpl.save();

    }
}
