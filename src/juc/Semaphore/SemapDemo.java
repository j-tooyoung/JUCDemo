package juc.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 允许多个线程进入临界区
 */
public class SemapDemo implements Runnable {

    final Semaphore semp = new Semaphore(5);


    @Override
    public void run() {
        try {
            semp.acquire();
            // 模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            // 释放信号量
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SemapDemo semapDemo = new SemapDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.submit(semapDemo);
        }
    }
}
