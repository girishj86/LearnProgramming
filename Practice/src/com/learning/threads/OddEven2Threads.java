public class OddEven2Threads {

    public static void main(String[] args) {
        LockObject lock = new LockObject("even");
        Thread threadEven = new ThreadEven(lock);
        Thread threadOdd = new ThreadOdd(lock);
        threadEven.setName("EvenThread");
        threadEven.start();
        threadOdd.setName("OddThread");
        threadOdd.start();
    }
}

class LockObject {
    String condition;
    public LockObject(String condition) {
        this.condition = condition;
    }
}

class ThreadEven extends Thread {
    int counter = 0;
    LockObject lock;
    ThreadEven(LockObject lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        while (counter <= 20) {
            synchronized (lock) {
                while (lock.condition.equals("Odd")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " printed by " + Thread.currentThread().getName());
                counter = counter + 2;
                lock.condition = "Odd";
                lock.notifyAll();
            }
        }
    }
}

class ThreadOdd extends Thread {
    int counter = 1;
    LockObject lock;
    ThreadOdd(LockObject lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        while (counter <= 20) {
            synchronized (lock) {
                while (lock.condition.equals("Even")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " printed by " + Thread.currentThread().getName());
                counter = counter + 2;
                lock.condition = "Even";
                lock.notifyAll();
            }
        }
    }
}
