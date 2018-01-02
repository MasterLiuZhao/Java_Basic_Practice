package com.liuzhao.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericList {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("dgdfg");
        list.add("gdgr");

        list.forEach(temp -> System.out.println(temp.length()));
    }

}
