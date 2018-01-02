package com.liuzhao.reflect.proxy;

public class Test {

    public static void main(String[] args){

        Person student = new Student();

        student = (Person) ProxyFactory.getProxy(student);

        student.say();
        student.walk("Nan Shan jie dao");

    }
}
