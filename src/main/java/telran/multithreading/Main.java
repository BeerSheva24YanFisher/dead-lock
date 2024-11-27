package telran.multithreading;

public class Main {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Worker thread1 = new Worker(lock1, lock2);
        Worker thread2 = new Worker(lock2, lock1);

        thread1.start();
        thread2.start();
    }
}