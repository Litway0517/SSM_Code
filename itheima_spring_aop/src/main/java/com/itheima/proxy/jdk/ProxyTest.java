package com.itheima.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        // 增强对象
        final Enhance_Advice enhance_advice = new Enhance_Advice();

        // 目标方法
        final Target target = new Target();

        // 这里要用接口去接. 父类接受子类. 接口是目标类和代理类的共同父类
        TargetInterface targetInterface = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),     // 目标对象 的类加载器
                target.getClass().getInterfaces(),      // 目标对象 相同的接口字节码对象数组

                // 调用代理对象的任何方法, 实质执行的都是invoke方法
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        enhance_advice.before();
                        // 执行目标方法
                        Object invoke = method.invoke(target, args);
                        enhance_advice.afterRunning();
                        return invoke;
                    }
                }

        );

        // 调用方法
        targetInterface.save();



    }

}
