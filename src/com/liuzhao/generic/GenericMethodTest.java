package com.liuzhao.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest {

    public static <T> void display(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static <T> T copy(List<? extends T> sources, List<T> destination) {
        T lastOne = null;
        for (int i = 0; i < sources.size(); i++) {
            lastOne = sources.get(i);
            destination.add(lastOne);
        }
        return lastOne;
    }

    public static <T> T addDifference(List<T> sources, List<? super T> target) {
        T lastOne = null;

        for (int i = 0; i < sources.size(); i++) {
            T processData = sources.get(i);
            boolean different = false;
            for (int j = 0; j < target.size(); j++) {
                T temp = (T) target.get(j);
                if (!processData.equals(temp)) {
                    different = true;
                    break;
                }
            }
            if(different){
                target.add(processData);
            }
        }

        if (target != null && target.size() == 0) {
            target.addAll(sources);
        }
        return lastOne;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(123);
        integerList.add(456);
        integerList.add(789);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(11.22);
        doubleList.add(33.44);
        doubleList.add(55.66);

        List<Number> numberList = new ArrayList<>();

        display(integerList);
        display(doubleList);
        display(numberList);

        System.out.println("After execute copy");
        copy(integerList, numberList);
        display(numberList);

        System.out.println("After execute copy");
        copy(doubleList, numberList);
        display(numberList);

        numberList = new ArrayList<>();

        System.out.println("After execute addDifference");
        addDifference(integerList, numberList);
        display(numberList);

        System.out.println("After execute addDifference");
        addDifference(doubleList, numberList);
        display(numberList);
    }
}
