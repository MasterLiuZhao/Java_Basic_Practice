package com.liuzhao.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallMethodTest {
    private int i;

    private void mySecret(String password){
        System.out.println("I'm CallMethodTest mySecret() method and my parameter i = " + i + " password = " + password);
    }

    public void info() {
        System.out.println("I'm CallMethodTest info() method and my parameter i = " + i);
    }

    public void test(String str) {
        System.out.println("I'm CallMethodTest test() method and my parameter i = " + i + " str = " + str);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.liuzhao.reflect.CallMethodTest");
        Object object = clazz.newInstance();
        Object secondObject = clazz.newInstance();

        Method setiMthod = clazz.getMethod("setI", int.class);
        setiMthod.invoke(object, 12);

        Method infoMethod = clazz.getMethod("info");
        infoMethod.invoke(object);

        Method testMethod = clazz.getMethod("test", String.class);
        testMethod.invoke(object, "abcd");

        /*
        Can not get private method by this way... It will throw exception java.lang.NoSuchMethodException
        But you can get private method through Class.getDeclaredMethod().
        Method secretMthod = clazz.getMethod("mySecret", String.class);
        secretMthod.invoke(object, "pass123");
        */

        Method secretMthod = clazz.getDeclaredMethod("mySecret", String.class);
        //secretMthod.setAccessible(true);
        secretMthod.invoke(object, "pass1234");

        System.out.println("Create... new Object...");
        infoMethod.invoke(secondObject);
        testMethod.invoke(secondObject, "kkkkk");
    }
}
