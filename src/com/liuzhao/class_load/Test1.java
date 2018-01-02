package com.liuzhao.class_load;

public class Test1 {

    static {
        a = 2;
        System.out.println("Execute static statement.");
    }

    public static int a = 5;
    public static int b = 6;
    public static int c;

    static {
        b = 9;
        System.out.println("Execute static statement.");
    }

    public static void main(String[] args) {
        System.out.println("Execute main() method.");
        System.out.println(Test1.a);
        System.out.println(Test1.b);
        System.out.println(Test1.c);

        new Test1();
        new Test1();
    }
}
