package homeWork3.item1;

public class Triger {
    public synchronized void triger() {
        try {
            notify();
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
