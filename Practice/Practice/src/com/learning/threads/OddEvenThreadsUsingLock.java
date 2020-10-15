import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenThreadsUsingLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition evenCondition = lock.newCondition();
        Condition oddCondition = lock.newCondition();
        StringBuilder flag = new StringBuilder("even");

        Thread evenThread = new Thread() {
            int counter = 0;
            @Override
            public void run() {
                while (counter <= 20) {
                    try {
                        lock.lock();
                        if (flag.toString().equals("odd")) {
                            try {
                                evenCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(counter + " printed by " + Thread.currentThread().getName());
                        counter = counter + 2;
                        setFlag(flag, "odd");
                        oddCondition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        Thread oddThread = new Thread() {
            int counter = 1;
            @Override
            public void run() {
                while (counter <= 20) {
                    try {
                        lock.lock();
                        if (flag.toString().equals("even")) {
                            try {
                                oddCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(counter + " printed by " + Thread.currentThread().getName());
                        counter = counter + 2;
                        setFlag(flag, "even");
                        evenCondition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        evenThread.setName("EvenThread");
        evenThread.start();
        oddThread.setName("OddThread");
        oddThread.start();
    }

    private static void setFlag(StringBuilder flag, String odd) {
        flag.setLength(0);
        flag.append(odd);
    }
}
