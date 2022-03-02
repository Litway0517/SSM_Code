package com.itheima.proxy.aop;

/**
 * 目标
 *
 * @author DELL_
 * @date 2022/03/02
 */

// 目标对象
public class Target implements TargetInterface {

    // 待增强的目标方法
    public void save() {
        System.out.println("save running.....");
    }


    public void testThrow() {
        System.out.println("testing exception...");
        int i = 1 / 0;
    }

}
