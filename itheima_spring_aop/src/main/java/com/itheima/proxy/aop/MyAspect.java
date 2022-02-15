package com.itheima.proxy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before() {
        System.out.println("前置增强: 执行目标方法之前的 增强方法");
    }


    public void afterReturning() {
        System.out.println("后置增强: 执行目标方法之后的 增强方法");
    }


    /*
        ProceedingJoinPoint: 正在执行的连接点 -> 实际上就是切点
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强: 环绕前...");
        Object proceed = pjp.proceed();
        System.out.println("环绕增强: 环绕后...");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("异常抛出增强....");
    }

}