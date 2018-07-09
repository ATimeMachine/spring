package com.example.aop.demo2;

import java.util.Date;

/**
 * FileName: Logger
 * Author:   SunEee
 * Date:     2018/7/9 14:31
 * Description:
 */
public class Logger implements ILogger {
    @Override
    public void start() {
        System.out.println("日志开始:" + new Date());
    }

    @Override
    public void end() {
        System.out.println("日志结束:" + System.currentTimeMillis());
    }
}
