package com.liuzhao.reflect.proxy;

public class Student implements Person {

    @Override
    public void say() {
        System.out.println("I'm Student say() method.");
    }

    @Override
    public void walk(String street) {
        System.out.println("I'm Student walk() method and we will walk on " + street);
    }

    public void work(){
        System.out.println("I'm Student work() method.");
    }
}
