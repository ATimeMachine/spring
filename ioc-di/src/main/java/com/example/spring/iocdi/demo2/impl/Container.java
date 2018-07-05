package com.example.spring.iocdi.demo2.impl;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

/**
 * FileName: Container
 * Author:   SunEee
 * Date:     2018/7/4 15:38
 * Description: IOC的容器
 */
public class Container {

    private final String NAME_BEAN= "namebean.properties";
    private final String PARAM_BEAN= "parambean.properties";


    private static Map<Class<?>,Object> classMap = new HashMap<>(); //容器

    private static final Properties beans = new Properties();

    private static final Properties params = new Properties();

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
        loadProperties(beans,classLoader,NAME_BEAN);
        loadProperties(params,classLoader,PARAM_BEAN);
        creatInstances(classLoader);
    }

    /**
     * 加载配置文件
     * @param properties 配置文件对象
     * @param classLoader 类加载器
     * @param name 配置文件的名称
     */
    private void loadProperties(Properties properties,ClassLoader classLoader,String name){
        Properties temp; //临时参数
        try {
            Enumeration<URL> urls = classLoader.getResources(name);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                temp = PropertiesLoaderUtils.loadProperties(new UrlResource(url));
                properties.putAll(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实例化对象
     * @param classLoader 类加载器
     */
    private void creatInstances(ClassLoader classLoader) {
        Set<String> names = beans.stringPropertyNames();
        for (String name : names) {
            try {
                Class<?> instanceClass = ClassUtils.forName(name, classLoader);
                int count = getParamCount(instanceClass);
                Class<?>[] parameterTypes = getParameterTypes(instanceClass,count); //获取构造方法的参数类型
                Field[] declaredFields = instanceClass.getDeclaredFields();//获取私有属性
                Class<?>[] interfaces = instanceClass.getInterfaces();//获得实现的接口
                Object[] args = confirmParam(instanceClass,parameterTypes, declaredFields);//获取对象参数

                Constructor<?> constructor = instanceClass.getDeclaredConstructor(parameterTypes);
                Object o = constructor.newInstance(args);

                packageData(interfaces, o);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    private void packageData(Class<?>[] interfaces, Object o) {
        classMap.put(o.getClass(), o);
        for (Class<?> anInterface : interfaces) {
            classMap.put(anInterface, o);
        }
    }

    /**
     * 获得实例对象的构造函数的参数
     * @param instanceClass 实例对象的字节码文件
     * @param parameterTypes 实例对象的构造函数的参数
     * @param declaredFields 实例对象的私有对象
     * @return 获得实例对象的构造函数的参数
     */
    private Object[] confirmParam(Class<?> instanceClass,Class<?>[] parameterTypes,Field[] declaredFields){
        Object[] objects = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clazz = parameterTypes[i];
            Object o = classMap.get(clazz);
            if (null != o) {
                objects[i] = o; //参数是对象
                continue;
            }

            Field field = declaredFields[i];
            String key =instanceClass.getName() + "." + field.getName();
            String property = params.getProperty(key);
            if (null != property){
                if (clazz.equals(Integer.class)) {
                    objects[i] = Integer.parseInt(property); //参数是Integer
                } else {
                    objects[i] = property;
                }
            }
        }
        return objects;
    }


    /**
     * 获得类字节码的构造函数参数类型
     * @param instanceClass 类字节码文件
     * @param length 配置文件的参数条数
     * @return 获得类字节码的构造函数参数类型
     */
    private Class<?>[] getParameterTypes(Class<?> instanceClass, Integer length) {
        Constructor<?>[] declaredConstructors = instanceClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (length == parameterTypes.length) {
                return parameterTypes;
            }
        }
        return new Class[0];
    }

    /**
     * 获取参数
     * @param clazz clazz
     * @return value
     */
    private int getParamCount(Class<?> clazz) {
        List<Object> result = new ArrayList<>();
        Set<Map.Entry<Object, Object>> entries = params.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            String name = String.valueOf(entry.getKey());
            if (name.startsWith(clazz.getName())){
                result.add(entry.getValue());
            }
        }
        return result.size();
    }
}
