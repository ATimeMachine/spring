package com.example.spring.iocdi.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: Container
 * Author:   SunEee
 * Date:     2018/7/4 15:38
 * Description: IOC的容器
 */
public class Container {

    private static Map<Class<?>,Object> classMap = new HashMap<>(); //容器

    public static  <T>void build(Class<T> clazz,Object o){ //构建容器
        classMap.put(clazz,o);
    }

    public static <T>T get(Class<T> clazz){
        Object o = classMap.get(clazz);
        return clazz.cast(o);
    }
}
