package com.example.spring.iocdi.demo2.impl;

import com.example.spring.iocdi.demo2.face.Animal;
import com.example.spring.iocdi.demo2.face.Fruit;

/**
 * FileName: Wrold
 * Author:   SunEee
 * Date:     2018/7/4 15:34
 * Description: 利用接口减低耦合性和控制反转，依赖注入解释
 */
public class Wrold {

    //接口类型，具体传入哪个对象是无需关注的，因为接口是一种规则，
    // getInfo方法进来的参数一定是实现Fruit接口类的对象。
    // 即使有一天将Apple类删除，Fruit接口还在，那么getInfo方法就有用，
    // 并且随意扩展一个新的类来实现Fruit接口，这叫做向后兼容。
    private Fruit fruit; //利用接口减低耦合性

    private Animal animal;//利用接口减低耦合性

    public Wrold(Fruit fruit, Animal animal) { //控制反转，实例化Fruit,Animal在主动权提取到Wrold类的外面
        this.fruit = fruit;
        this.animal = animal;
    }

    public void action() {
        //Wrold类就完全不用管Fruit,Animal是怎么样实例的，而是仅仅调用Fruit,Animal的方法就行了。这种模式就是依赖注入！！
        System.out.println(fruit.getInfo());
        System.out.println(animal.theAnimal());
    }
}
