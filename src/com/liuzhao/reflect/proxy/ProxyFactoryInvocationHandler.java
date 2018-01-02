package com.liuzhao.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyFactoryInvocationHandler implements InvocationHandler {
    private Object targer;

    public ProxyFactoryInvocationHandler(Object targer) {

        this.targer = targer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("I will log some information.");

        System.out.println("Call target method.");

        if(args != null && args.length > 0){
            result = method.invoke(targer, args);
        }else{
            result = method.invoke(targer);
        }

        System.out.println("Finished target method. I will submit transaction if I got one.");

        return result;
    }


    public Object getTarger() {
        return targer;
    }

    public void setTarger(Object targer) {
        this.targer = targer;
    }
}
