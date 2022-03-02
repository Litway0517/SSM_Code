package com.itheima.proxy.annotation;


import org.springframework.stereotype.Component;

// 将目标类的加载管理事项交给spring容器
@Component("target")
public class Target implements TargetInterface {

    public void save() {
        System.out.println("save running.....");
    }


    public void testThrow() {
        System.out.println("testing exception...");
        int i = 1 / 0;
    }

}
