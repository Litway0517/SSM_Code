package com.itheima.proxy.aop;

public class Target implements TargetInterface {

    public void save() {
        System.out.println("save running.....");
    }


    public void testThrow() {
        int i = 1 / 0;
        System.out.println("testing exception...");
    }

}
