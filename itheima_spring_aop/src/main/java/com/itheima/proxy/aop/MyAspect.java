package com.itheima.proxy.aop;

import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 通知
 *
 * @author DELL_
 * @date 2022/03/02
 */

// 通知类
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


    public void after() {
        System.out.println("最终增强: 无论异常出现与否都会执行");
    }

}
