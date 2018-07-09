package com.example.aop.demo1;

import java.util.Date;

/**
 * FileName: Logger
 * Author:   SunEee
 * Date:     2018/7/9 13:46
 * Description: 模拟日志
 */
public class Logger {
    public static void start() {
        System.out.println("日志开始:" + new Date());
    }

    public static void end() {
        System.out.println("日志结束:" + System.currentTimeMillis());
    }
}
