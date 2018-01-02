package com.liuzhao.thread;

import com.liuzhao.SimpleEnum;

public class SimpleEnumTest {

    public static void main(String[] args) {
        SimpleEnum simpleEnum = SimpleEnum.SPRING;
        switch (simpleEnum){
            case SPRING:
                System.out.println("It is Spring now.");
                break;
            case SUMMER:
                System.out.println("It is Summer now.");
                break;
            case AUTUMN:
                System.out.println("It is Autumn now.");
                break;
            case WINTER:
                System.out.println("It is Winter now.");
                break;
        }

        for(SimpleEnum simpleEnum1 : SimpleEnum.values()){
            System.out.println(simpleEnum1);
        }
    }

}
