package juc.object;


/**
 * synchronized
 * 指定加锁对象
 * 作用于实例方法
 * 作用于静态方法 class
 */
public class synchroDemo implements Runnable {

    static synchroDemo instance = new synchroDemo();

    static int i = 0;

    // 改成静态方法
    public synchronized void increase() {
        i++;
    }

    @Override
    public  void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(instance);
//        Thread t2 = new Thread(instance);
//        t1.start();t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(i);

        Thread t3 = new Thread(new synchroDemo());
        Thread t4 = new Thread(new synchroDemo());
        t3.start();t4.start();
        t3.join(); t4.join();
        System.out.println(i);
    }
}
