package com.example.aop.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FileName: ProxyHello2
 * Author:   SunEee
 * Date:     2018/7/9 14:40
 * Description:
 */
public class ProxyHello2 implements InvocationHandler{
    private Object proxy;

    private Object target;

    public Object bind(Object target, Object proxy) {
        this.target = target;
        this.proxy = proxy;
        Class<?> clazz = this.target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> clazz = this.proxy.getClass();
        Method start = clazz.getDeclaredMethod("start");
        start.invoke(this.proxy);
        Object result = method.invoke(this.target, args);
        Method end = clazz.getDeclaredMethod("end");
        end.invoke(this.proxy);

        return result;
    }
}
