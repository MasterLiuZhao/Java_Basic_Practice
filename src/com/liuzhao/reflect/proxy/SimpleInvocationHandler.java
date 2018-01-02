package com.liuzhao.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SimpleInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Execute SimpleInvocationHandler invoke() method.");

        if(args != null && args.length > 0){
            for(Object value : args){
                System.out.println("pass parameter: " + value);
            }
        }else{
            System.out.println("It didn't pass any parameter.");
        }

        System.out.println("I got method: " + method);

        return null;
    }
}
