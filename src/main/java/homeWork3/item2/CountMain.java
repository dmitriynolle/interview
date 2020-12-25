package homeWork3.item2;

import java.util.concurrent.locks.ReentrantLock;


public class CountMain {

    public static void main(String[] args) {

        Counter counter = new Counter();
        ReentrantLock lock = new ReentrantLock();

        CountThread threadOne = new CountThread("1", counter, lock);
        CountThread threadTwo = new CountThread("2", counter, lock);
        CountThread threadThree = new CountThread("3", counter, lock);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }


}
