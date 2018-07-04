package com.example.spring.iocdi.demo2;

/**
 * FileName: Wrold
 * Author:   SunEee
 * Date:     2018/7/4 15:34
 * Description:
 */
public class Wrold {

    private Apple apple;

    private Cat cat;

    public Wrold(Apple apple, Cat cat) {
        this.apple = apple;
        this.cat = cat;
    }

    public void see() {
        System.out.println(apple.getInfo());
        System.out.println(cat.theCat());
    }
}
