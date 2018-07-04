package com.example.spring.iocdi.demo2.impl;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * FileName: Container
 * Author:   SunEee
 * Date:     2018/7/4 15:38
 * Description: IOC的容器
 */
public class Container {

    private static Map<Class<?>,Object> classMap = new HashMap<>(); //容器

    public static final  Properties properties = new Properties();

    //原始构建容器，新建对象在外面，麻烦 ! 应该用配置文件（注解），详情看本类的构造器
    public static  <T>void build(Class<T> clazz,Object o){
        classMap.put(clazz,o);
    }


    /**
     * 获取对象
     * @param clazz 类的字节
     * @return 对象
     */
    public static <T>T get(Class<T> clazz){
        Object o = classMap.get(clazz);

        return clazz.cast(o);
    }

    public Container() {
        initialize();
    }

    private void initialize() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Set<String> name = new LinkedHashSet<>(loadNames(Wrold.class,classLoader));

    }



    /**
     * 获取制定的类名称
     * @param clazz 类的字节码
     * @param classLoader 类加载器
     * @return 结果
     */
    private List<String> loadNames(Class<?> clazz, ClassLoader classLoader){
        Properties temp; //临时参数
        String name = clazz.getName();
        ArrayList<String> result = new ArrayList<>();

        try {
            Enumeration<URL> urls = classLoader.getResources("myclass.properties");
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                temp = PropertiesLoaderUtils.loadProperties(new UrlResource(url));
                properties.putAll(temp);
                String factoryClassNames = temp.getProperty(name);
                result.addAll(Arrays.asList(StringUtils.commaDelimitedListToStringArray(factoryClassNames)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private <T> List<T> creatInstances(Class<T> clazz,Class<?>[] parameterTypes, ClassLoader classLoader,Set<String> names) {
        List<T> instances = new ArrayList<T>(names.size());
        for (String name : names) {

        }

        return instances;
    }
}
