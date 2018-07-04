package com.example.spring.iocdi.demo2;

/**
 * FileName: Apple
 * Author:   SunEee
 * Date:     2018/7/4 15:25
 * Description:
 */
public class Apple {
    private String name;

    private String color;

    private Integer count;

    public Apple(String name, String color, Integer count) {
        this.name = name;
        this.color = color;
        this.count = count;
    }

    public String getInfo() {
        return "苹果详情-品牌：" + name + ",颜色：" + color + "，数量：" + count;
    }
}
