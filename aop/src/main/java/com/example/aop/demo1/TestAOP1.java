package com.example.aop.demo1;

import org.junit.Test;

/**
 * FileName: TestAOP1
 * Author:   SunEee
 * Date:     2018/7/9 14:04
 * Description: 测试类1
 */
public class TestAOP1 {

    @Test
    public void test1() {
        IHello proxyInstence = (IHello) new ProxyHello1().bind(new Hello()); //代理类
        proxyInstence.sayHello("哈哈哈");
    }
}
