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
        /*
            这里面加载的spring配置文件仍然是写固定的, 因此需要解耦. 配置到web.xml文件下, 作为一个初始化参数.
            如果以后更换了配置文件的名称, 那么不需要更改本处的源码, 而只需要去更改web.xml中的配置文件名称.
            之前需要改两处, 现在只需要更改一处.
         */
        // ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 读取web.xml中的全局初始化参数
        ServletContext servletContext = servletContextEvent.getServletContext();
        String springConfiguration = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(springConfiguration);
        // 将spring上下文对象存储到最大的域中, 即application域
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
