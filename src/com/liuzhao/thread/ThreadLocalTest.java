package com.liuzhao.thread;

public class ThreadLocalTest implements Runnable {
    private String name;
    private ThreadLocal<String> localVar = new ThreadLocal<>();

    public ThreadLocalTest(String name, String tempName) {
        this.name = name;
        this.localVar.set(tempName);
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            if(i == 5){
                name = Thread.currentThread().getName();
                localVar.set(Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName() + ", i = " + i + ", name = " + name + ", localVar = " + localVar.get());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadLocal<String> getLocalVar() {
        return localVar;
    }

    public void setLocalVar(ThreadLocal<String> localVar) {
        this.localVar = localVar;
    }

    public static void main(String[] args){
        ThreadLocalTest test = new ThreadLocalTest("name1", "name2");

        Thread thread1 = new Thread(test, "Thread1");
        Thread thread2 = new Thread(test, "Thread2");

        thread1.start();
        thread2.start();
    }
}
