package com.liuzhao.reflect;

public class CreateObjectTest {

    public void info(){
        System.out.println("I'm CreateObjectTest info() method.");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class<?> clazz = Class.forName("com.liuzhao.reflect.CreateObjectTest");

        CreateObjectTest createObjectTest = (CreateObjectTest) clazz.newInstance();

        createObjectTest.info();
    }
}
