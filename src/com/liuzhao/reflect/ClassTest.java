package com.liuzhao.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings(value = "unchecked")
@Deprecated
public class ClassTest {
    private int i;
    public String str;

    public ClassTest() {
    }

    public ClassTest(int i, String str) {
        this.i = i;
        this.str = str;
    }

    private void test(String temp) {
        System.out.println("This is ClassTest test(String) method...");
    }

    public void info() {
        System.out.println("This is ClassTest info() method...");
    }

    class MySecondClass {
        private int a;
        private int b;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<ClassTest> clazz = ClassTest.class;

        System.out.println();
        System.out.println("Display All Fields.");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();
        System.out.println("Display All Constructors.");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();
        System.out.println("Display All Methods.");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();
        System.out.println("Display All Annotation.");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println();
        System.out.println("Display All Inner Class.");
        Class<?>[] innerClass = clazz.getDeclaredClasses();
        for(Class c : innerClass){
            System.out.println(c);
        }

        System.out.println();
        Package packageName = clazz.getPackage();
        System.out.println("Package Name: " + packageName);

        Class superClass = clazz.getSuperclass();
        System.out.println("Super Class: " + superClass);


    }
}
