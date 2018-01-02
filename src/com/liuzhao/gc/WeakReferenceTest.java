package com.liuzhao.gc;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String[] args){
        String str = new String("My Original String");

        WeakReference weakReference = new WeakReference(str);
        str = null;

        System.out.println(weakReference.get());

        System.gc();

        System.out.println(weakReference.get());
    }

}
