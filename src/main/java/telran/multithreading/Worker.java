package telran.multithreading;

public class Worker extends Thread {
    private final Object lock1;
    private final Object lock2;

    public Worker(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void f1() {
        synchronized (lock1) {
            System.out.printf("Thread %s locked lock1%n", getName());
            synchronized (lock2) {
                System.out.printf("Thread %s locked lock2%n", getName());
            }
        }
    }

    public void f2() {
        synchronized (lock2) {
            System.out.printf("Thread %s locked lock2%n", getName());
            synchronized (lock1) {
                System.out.printf("Thread %s locked lock1%n", getName());
            }
        }
    }

    @Override
    public void run() {
        f1();
        f2();
    }
}