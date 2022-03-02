package com.itheima.proxy.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 使用@Component告诉spring容器, 本类的创建权交给spring容器管理
@Component("myAspect")


// 添加@Aspect注解 标识此类是  切面类(通知类 -> 通知集合  增强方法集合)
@Aspect
public class MyAspect {


    // 定义一个方法, 用来写 切点表达式
    @Pointcut(value = "execution(void com.itheima.proxy.annotation.*.*(..))")
    public void pointcut() {}


    /*
        配置前置增强
        首先, @Before注解的名称就决定了这个是 前置通知.
        value用来表述 切点表达式.
     */
    // @Before(value = "execution(void com.itheima.proxy.annotation.*.*(..))")
    @Before(value = "MyAspect.pointcut()")
    public void before() throws InterruptedException {
        System.out.println("前置增强: 执行目标方法之前的 增强方法");
    }

    // @AfterReturning(value = "pointcut")
    public void afterReturning() {
        System.out.println("后置增强: 执行目标方法之后的 增强方法");
    }


    /*
        ProceedingJoinPoint: 正在执行的连接点 -> 实际上就是切点
     */
    @Around(value = "execution(void com.itheima.proxy.annotation.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Thread.sleep(3000);
        System.out.println("环绕增强: 环绕前...");
        Object proceed = pjp.proceed();
        System.out.println("环绕增强: 环绕后...");
        return proceed;
    }


    @AfterThrowing(value = "pointcut()")
    public void afterThrowing() {
        System.out.println("异常抛出增强....");
    }


    @After(value = "execution(void com.itheima.proxy.annotation.*.*(..))")
    public void after() {
        System.out.println("最终增强: 无论异常出现与否都会执行");
    }

}
