package com.example.spring.iocdi.demo1;

/**
 * FileName: Controller
 * Author:   SunEee
 * Date:     2018/7/4 14:28
 * Description: 初步认识IOC 和 DI
 */
public class Controller {
    public IMysql iMysql;

    public Controller(IMysql iMysql) { //控制反转，实例化IMysql在主动权提出到Controller类的外面
        this.iMysql = iMysql;
    }

    public void action() {
        //Controller类中不需要实例化DbMysql，而是将DbMysql类的实例作为参数传递（或者单独写一个接收实例的方法处理），
        // 这样Controller类就完全不用管DbMysql是怎么样实例的，而是仅仅调用DbMysql中的query方法就行了。这种模式就是依赖注入
        System.out.println(iMysql.query());
    }
}
