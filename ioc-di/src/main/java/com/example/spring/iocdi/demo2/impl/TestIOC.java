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
        Container.build(Apple.class,new Apple("红富士", "red", 10));
        Container.build(Cat.class,new Cat("小白", 2));
        Container.build(Wrold.class,new Wrold(Container.get(Apple.class), Container.get(Cat.class)));

        Wrold wrold = Container.get(Wrold.class);
        wrold.action();
    }
}
