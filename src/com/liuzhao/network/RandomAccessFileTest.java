package com.liuzhao.network;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest extends Thread {
    private int position;

    public RandomAccessFileTest(int position) {
        this.position = position;
    }

    @Override
    public void run() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("tstNIO.txt", "rw");
            randomAccessFile.seek(this.position);

            for (int i = 0; i < 20; i++) {
                randomAccessFile.write(new String(Thread.currentThread().getName() + "\n").getBytes());
                Thread.sleep(1);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        RandomAccessFileTest thread1 = new RandomAccessFileTest(0);
        thread1.setName("WriteFromPosition0");
        thread1.start();

        RandomAccessFileTest thread2 = new RandomAccessFileTest(400);
        thread2.setName("WriteFromPosition400");
        thread2.start();

    }

}
