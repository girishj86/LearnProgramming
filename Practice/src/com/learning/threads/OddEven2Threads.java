import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class OddEven2Threads {

    public static void main(String[] args) {
        Object lock = new Object();
        StringBuilder flag = new StringBuilder("Even");
        Thread threadEven = new ThreadEven(lock, flag);
        Thread threadOdd = new ThreadOdd(lock, flag);
        threadEven.setName("EvenThread");
        threadEven.start();
        threadOdd.setName("OddThread");
        threadOdd.start();
    }
}

class ThreadEven extends Thread {
    int counter = 0;
    Object lock;
    StringBuilder flag;
    ThreadEven(Object lock, StringBuilder flag) {
        this.lock = lock;
        this.flag = flag;
    }
    @Override
    public void run() {
        while (counter <= 20) {
            synchronized (lock) {
                while (flag.toString().equals("Odd")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " printed by " + Thread.currentThread().getName());
                counter = counter + 2;
                flag.setLength(0);
                flag.append("Odd");
                lock.notifyAll();
            }
        }
    }
}

class ThreadOdd extends Thread {
    int counter = 1;
    Object lock;
    StringBuilder flag;
    ThreadOdd(Object lock, StringBuilder flag) {
        this.lock = lock;
        this.flag = flag;
    }
    @Override
    public void run() {
        while (counter <= 20) {
            synchronized (lock) {
                while (flag.toString().equals("Even")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " printed by " + Thread.currentThread().getName());
                counter = counter + 2;
                flag.setLength(0);
                flag.append("Even");
                lock.notifyAll();
            }
        }
    }
}