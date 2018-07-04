package com.example.spring.iocdi.demo2.impl;

import com.example.spring.iocdi.demo2.face.Animal;
import com.example.spring.iocdi.demo2.face.Fruit;

/**
 * FileName: Wrold
 * Author:   SunEee
 * Date:     2018/7/4 15:34
 * Description: 利用接口减低耦合性
 */
public class Wrold {

    private Fruit fruit; //利用接口减低耦合性

    private Animal animal;//利用接口减低耦合性

    public Wrold(Fruit fruit, Animal animal) {
        this.fruit = fruit;
        this.animal = animal;
    }

    public void action() {
        System.out.println(fruit.getInfo());
        System.out.println(animal.theAnimal());
    }
}
