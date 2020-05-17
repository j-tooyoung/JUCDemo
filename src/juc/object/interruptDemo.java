package juc.object;

public class interruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted");
                        break;
                    }
                    try {
                        // sleep方法被中断会抛出异常，清楚中断标记
                        // sleep 方法不释放锁
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted when sleep");
                        // 设置中断状态
                        Thread.currentThread().interrupt();
//                        e.printStackTrace();
                    }

                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
