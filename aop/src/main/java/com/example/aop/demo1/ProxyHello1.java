package com.example.aop.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FileName: ProxyHello1
 * Author:   SunEee
 * Date:     2018/7/9 13:56
 * Description: hello代理类
 */
public class ProxyHello1 implements InvocationHandler {

    private Object target;

    public Object bind(Object object) {
        this.target = object;
        Class<?> clazz = this.target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Logger.start();
        result = method.invoke(target, args);
        Logger.end();
        return result;
    }
}
