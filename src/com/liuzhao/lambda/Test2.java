package com.liuzhao.lambda;

import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("zhe", "ge", "you", "dian", "xiao", "fu", "za", "o");

        // 不使用 Lambda 表达式
        for(String value : list){
            System.out.println(value);
        }

        // 使用 Lambda 表达式
        list.forEach(value -> System.out.println(value));

    }

}
