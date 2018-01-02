package com.liuzhao.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

    public static void main(String[] args){
        String str = new String("My Original String Content");

        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(str, referenceQueue);
        str = null;

        System.out.println(phantomReference.get());

        System.gc();

        System.out.println(referenceQueue.poll() == phantomReference);

    }
}
