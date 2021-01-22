package homeWork3.item1;

public class PingPong {
    public static void main(String[] args) {
        Triger triger = new Triger();
        Thread ping = new Thread(() -> {
            while (true) {
                System.out.println("ping");
                triger.triger();
            }
        });
        Thread pong = new Thread(() -> {
            while (true) {
                System.out.println("pong");
                triger.triger();
            }
        });
        ping.start();
        pong.start();
    }
}
