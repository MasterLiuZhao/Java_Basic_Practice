package com.liuzhao.generic;

import java.util.ArrayList;
import java.util.List;

public class Custom<T> {
    private T info;

    public Custom() {
    }

    public Custom(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args){
        Custom c1 = new Custom();
        c1.setInfo(231);
        int first = (int) c1.getInfo();
        System.out.println(first);

        c1.setInfo("sfsdfs");
        String second = (String) c1.getInfo();
        System.out.println(second);


        Custom<String> c2 = new Custom<>();
        c2.setInfo("asfsdf");
        System.out.println(c2.getInfo());
        //c2.setInfo(423423);

        Custom<Integer> c3 = new Custom<>();
        c3.setInfo(34234);
        System.out.println(c3.getInfo());

        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list1.getClass() == list2.getClass());
        //System.out.println(list1 == list2);

    }
}
