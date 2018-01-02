package com.liuzhao.thread;

import java.util.concurrent.RecursiveAction;

public class RecursiveActionTest extends RecursiveAction {
    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    public RecursiveActionTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start > THRESHOLD){
            int middle = (start+end) / 2;

            RecursiveActionTest firstTask = new RecursiveActionTest(start, middle);
            RecursiveActionTest secondTask = new RecursiveActionTest(middle, end);

            firstTask.fork();
            secondTask.fork();
        }else{
            for(int i=start; i<end; i++){
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
        }
    }
}
