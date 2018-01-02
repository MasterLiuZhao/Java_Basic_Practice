package com.liuzhao.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new RecursiveActionTest(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);

    }

}
