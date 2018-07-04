package com.example.spring.iocdi.demo2;

/**
 * FileName: Cat
 * Author:   SunEee
 * Date:     2018/7/4 15:31
 * Description:
 */
public class Cat {
    private String name;

    private Integer age;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String theCat() {
        return "一个" + age + "岁的猫：" + name;
    }
}
