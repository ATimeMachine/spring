package com.example.spring.iocdi.demo2.impl;

import com.example.spring.iocdi.demo2.face.Animal;

/**
 * FileName: Cat
 * Author:   SunEee
 * Date:     2018/7/4 15:31
 * Description:
 */
public class Cat implements Animal{
    private String name;

    private Integer age;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String theAnimal() {
        return "一个" + age + "岁的猫：" + name;
    }
}
