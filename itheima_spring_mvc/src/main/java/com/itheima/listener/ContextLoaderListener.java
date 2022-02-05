package com.itheima.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 上下文加载器侦听器
 *
 * @author DELL_
 * @date 2022/02/05
 */
public class ContextLoaderListener implements ServletContextListener {


    /**
     * 环境初始化
     *
     * @param servletContextEvent servlet上下文事件
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 将spring上下文对象存储到最大的域中, 即application域
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("app", app);

        System.out.println("spring容器创建完毕.....");
    }

    /**
     * 环境破坏
     *
     * @param servletContextEvent servlet上下文事件
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
