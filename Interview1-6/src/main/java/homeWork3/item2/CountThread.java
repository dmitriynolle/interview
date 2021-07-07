package homeWork3.item2;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread extends Thread {
    Counter counter;
    ReentrantLock lock;

    public CountThread(String name, Counter counter, ReentrantLock lock) {
        super(name);
        this.counter = counter;
        this.lock = lock;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                CountThread.sleep((long) (Math.random() * 1000));
                lock.lock();

                System.out.print("Thread " + getName() + " ");
                counter.print();
                counter.increment();

            } catch (InterruptedException e) {
                e.printStackTrace();

            } finally {
                lock.unlock();
            }


        }
    }
}