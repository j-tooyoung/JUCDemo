package juc.object;

public class joinDemo {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        public void run() {
            for (i = 0; i < 1000000000; i++) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
//        Thread.sleep(10);

        // 等待addThread线程执行完毕
        addThread.join();
        System.out.println(i);
    }
}
