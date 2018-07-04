package com.example.spring.iocdi.demo1;

/**
 * FileName: Controller
 * Author:   SunEee
 * Date:     2018/7/4 14:28
 * Description: 控制器
 */
public class Controller {
    public IMysql iMysql;

    public Controller() {
        this.iMysql = new IMysql();
    }

    public void action() {
        System.out.println(iMysql.query());
    }
}
