package com.liuzhao.lambda;

public class Test1 {

    public static void main(String[] args) {
        // 正常的匿名内部类
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm Running.");
            }
        };

        Thread thread1 = new Thread(run1);
        thread1.start();

        // Lambda 表达式的匿名内部类
        Runnable run2 = () -> {
            System.out.println("I'm still running.");
        };

        Thread thread2 = new Thread(run2);
        thread2.start();
    }

}
