package juc.object;

public class DaeDemo {

    public static class DaemonT extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("i am alive");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonT t = new DaemonT();
        // 顺序必须放在start之前
//        t.setDaemon(true);
        t.start();
        // 当前线程 主线程休眠2秒
        Thread.sleep(2000);
    }
}
