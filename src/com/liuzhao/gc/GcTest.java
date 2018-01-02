package com.liuzhao.gc;

public class GcTest {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new GcTest();
            //System.gc();
            //Runtime.getRuntime().gc();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("System prepare to run GC...");
    }
}
