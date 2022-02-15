package com.itheima.proxy.aop;

public class Target implements TargetInterface {

    public void save() {
        System.out.println("save running.....");
    }


    public void testThrow() {
        System.out.println("testing exception...");
        int i = 1 / 0;
    }

}
