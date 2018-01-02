package com.liuzhao.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

public class MethodParameterTest {

    public void info(int i, String str, List<String> list){
        System.out.println("I'm MethodParameterTest info() method...");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<MethodParameterTest> clazz = MethodParameterTest.class;

        Method infoMethod = clazz.getMethod("info", int.class, String.class, List.class);

        int parameterCount = infoMethod.getParameterCount();
        System.out.println("There are " + parameterCount + " parameters in info() method.");

        Parameter[] parameters = infoMethod.getParameters();
        for(Parameter parameter : parameters){
            System.out.println(parameter);
            if(parameter.isNamePresent()){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());
                System.out.println(parameter.getParameterizedType());
            }
        }
    }

}
