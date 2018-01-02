package com.liuzhao.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericSuperTest {

    public static void loopup(List<? super Integer> sources){
        for (int i = 0; i < sources.size(); i++) {
            System.out.println(sources.get(i));
        }
    }

    public static void loopupByWildcard(List<?> sources) {
        for (int i = 0; i < sources.size(); i++) {
            System.out.println(sources.get(i));
        }
    }


    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(213);
        integerList.add(34354);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(9999.9999);
        doubleList.add(8888.8888);

        List<Number> numberList = new ArrayList<>();

        List<String> stringList = new ArrayList<>();
        stringList.add("gdfg");
        stringList.add("dfgdf");

        loopup(integerList);
        loopup(numberList);
        //loopup(doubleList);
        //loopup(stringList);

        loopupByWildcard(integerList);
        loopupByWildcard(doubleList);
        loopupByWildcard(stringList);
    }
}
