package com.liuzhao.class_load;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoadTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println("loadClass Test1");
        classLoader.loadClass("com.liuzhao.class_load.Test1");

        System.out.println("Class forName() Test1");
        Class.forName("com.liuzhao.class_load.Test1");

        System.out.println("Test Class Load.....................................");

        Class<?> clazz = classLoader.loadClass("Hello");
        Object object = clazz.newInstance();
        Method testMethod = clazz.getMethod("test", String.class);
        testMethod.invoke(object, "");
    }
}
