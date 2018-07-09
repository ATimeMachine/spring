package com.example.aop.demo2;

/**
 * FileName: Hello
 * Author:   SunEee
 * Date:     2018/7/9 13:52
 * Description: hello的实现类
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String msg) {
        System.out.println("打招呼信息：" + msg);
    }
}
