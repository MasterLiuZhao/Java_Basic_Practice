package com.liuzhao.reflect.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object getProxy(Object target) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        ProxyFactoryInvocationHandler handler = new ProxyFactoryInvocationHandler(target);

        Object result = Proxy.newProxyInstance(classLoader, interfaces, handler);

        return result;
    }

}
