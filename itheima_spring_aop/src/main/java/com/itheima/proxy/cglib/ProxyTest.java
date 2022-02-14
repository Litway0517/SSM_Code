package com.itheima.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(String[] args) {

        // 增强对象
        final Enhance_Advice enhance_advice = new Enhance_Advice();

        // 目标方法
        final Target target = new Target();

        // 返回值就是动态生成的代理对象, 基于cglib
        // 1- 创建增强器
        Enhancer enhancer = new Enhancer();

        // 2- 设置父类(目标) -> 就是待执行的方法所在的那个类. 传入待执行方法所在类的字节码
        enhancer.setSuperclass(Target.class);

        // 3- 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 前置增强
                enhance_advice.before();

                Object invoke = method.invoke(target, args);

                // 后置增强
                enhance_advice.afterRunning();

                return invoke;
            }
        });

        //4- 创建代理对象
        Target proxy = (Target) enhancer.create();

        proxy.save();
    }

}
