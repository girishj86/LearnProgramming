public class DeadLockDemo {

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (object1) {
                    System.out.println("Obtained lock for Object1 by " + this.getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(this.getName() + " trying to obtain lock for Object2");
                    synchronized (object2) {
                        System.out.println("Obtained lock for Object2 by " + this.getName());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (object2) {
                    System.out.println("Obtained lock for Object2 by " + this.getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(this.getName() + " trying to obtain lock for Object1");
                    synchronized (object1) {
                        System.out.println("Obtained lock for Object1 by " + this.getName());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };

        thread1.setName("Thread1");
        thread1.start();
        thread2.setName("Thread2");
        thread2.start();

    }
}


