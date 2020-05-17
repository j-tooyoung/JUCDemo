package juc.object;

public class ThreadGroupName implements Runnable {

    public static void main(String[] args) {
        ThreadGroup printGroup = new ThreadGroup("printGroup");
        new Thread(printGroup, new ThreadGroupName(), "T1").start();
        new Thread(printGroup, new ThreadGroupName(), "T2").start();
        System.out.println(printGroup.activeCount());
        printGroup.list();
    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("i am: " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
