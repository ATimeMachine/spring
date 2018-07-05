package com.example.spring.iocdi.demo2.impl;

import org.junit.Test;

/**
 * FileName: TestIOC
 * Author:   SunEee
 * Date:     2018/7/4 15:36
 * Description:
 */
public class TestIOC {

    @Test
    public void test1() {
        new Container();
        Wrold wrold = Container.get(Wrold.class);
        wrold.action();
    }
}
