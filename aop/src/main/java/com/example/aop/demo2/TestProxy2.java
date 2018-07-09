package com.example.aop.demo2;

import org.junit.Test;

/**
 * FileName: TestProxy2
 * Author:   SunEee
 * Date:     2018/7/9 14:50
 * Description:
 */
public class TestProxy2 {

    @Test
    public void test1() {
        IHello proxy = (IHello) new ProxyHello2().bind(new Hello(), new Logger());
        proxy.sayHello("hahah");
    }
}
