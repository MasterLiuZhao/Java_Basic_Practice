package com.liuzhao.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {

    public static void main(String[] args) {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String value : map.keySet()) {
            System.out.println(value);
        }
    }

}
