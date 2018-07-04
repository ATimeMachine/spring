package com.example.spring.iocdi.demo1;

import org.junit.Test;

/**
 * FileName: TestIOC
 * Author:   SunEee
 * Date:     2018/7/4 14:33
 * Description: 测试
 */
public class TestIOC {

    @Test
    public void test1() {
        new Controller(new IMysql()).action();
    }
}
