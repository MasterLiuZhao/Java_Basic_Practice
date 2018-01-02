package com.liuzhao.generic;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest {

    public static void normalParameter(List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void wildcardParameter(List<?> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("sfdsf");

        //normalParameter(stringList);

        wildcardParameter(stringList);

        List<Integer> intList = new ArrayList<>();
        intList.add(342);

        wildcardParameter(intList);
    }
}
