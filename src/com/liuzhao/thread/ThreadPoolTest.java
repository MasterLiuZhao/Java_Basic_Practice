package com.liuzhao.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolTest implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }

    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(new ThreadPoolTest());
        pool.submit(new ThreadPoolTest());
        pool.submit(new ThreadPoolTest());

        pool.shutdown();
    }

}
