package com.itheima.proxy.jdk;


/*
    spring使用的名字叫做Advice. 但是很容易误解.
    实际上这个类是增强类. 就是说, 执行目标方法之前或者之后或者均执行这个类中的方法
 */
public class Enhance_Advice {


    public void before() {
        System.out.println("前置增强: 执行目标方法之前 执行该逻辑~");
    }


    public void afterRunning() {
        System.out.println("后置增强: 执行目标方法之后 执行该逻辑~");
    }


}
