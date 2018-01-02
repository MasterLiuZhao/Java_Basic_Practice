package com.liuzhao;

public class TestEnum {

    public static void main(String[] args){
        SimpleEnum spring = Enum.valueOf(SimpleEnum.class, "SPRING");
        System.out.println(spring);
    }

}
