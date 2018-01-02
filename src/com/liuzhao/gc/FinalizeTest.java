package com.liuzhao.gc;

public class FinalizeTest {
    private static FinalizeTest finalizeTest = null;

    public void info() {
        System.out.println("Test1 resource clear Finalize() method. run info() method at once.");
    }

    @Override
    protected void finalize() throws Throwable {
        finalizeTest = this;
    }

    public static void main(String[] args) {
        new FinalizeTest();
        //System.gc();

        System.runFinalization();
        finalizeTest.info();
    }

}
