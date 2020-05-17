package juc.RenenteranLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 */
public class FairLock implements Runnable {

//    public static ReentrantLock fairLock = new ReentrantLock();
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
//                fairLock.tryLock();  失败返回false,不等待
                fairLock.lock();        // 交替得到锁
                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "Thread_r1");
        Thread t2 = new Thread(r1, "Thread_r2");
        t1.start();
        t2.start();

    }
}
