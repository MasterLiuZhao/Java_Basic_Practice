package com.liuzhao.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SimpleProxy {

    public static void main(String[] args) {
        InvocationHandler handler = new SimpleInvocationHandler();

        ClassLoader classLoader = Person.class.getClassLoader();
        Class<?>[] intefaces = new Class[]{Person.class};

        Person p = (Person) Proxy.newProxyInstance(classLoader, intefaces, handler);

        p.say();
        p.walk("Tom Street");

    }

}
