import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        //Create custome threadpool with initial capacity of 2 worker threads
        CustomThreadPool threadPool = new CustomThreadPool(2);
        //create 5 tasks and submit to thread pool to work
        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task" + i);
            threadPool.submit(task);
        }
    }
}

class CustomThreadPool {

    int capacity;
    BlockingQueue<Task> queue = new LinkedBlockingQueue<Task>();

    CustomThreadPool(int capacity) {
        this.capacity = capacity;
        for (int i = 1; i <= capacity; i++) {
            CustomThread worker = new CustomThread(queue, "Worker" + i);
            worker.start();
        }
    }

    //add tasks to queue to be consumed by worker threads
    public void submit(Task task) {
        queue.offer(task);
    }
}

class CustomThread extends Thread {

    BlockingQueue<Task> queue;

    CustomThread(BlockingQueue queue, String name) {
        this.queue = queue;
        this.setName(name);
    }

    @Override
    public void run() {
        //keep each thread running always and polling the queue for new task
        while (true) {
            if (!this.queue.isEmpty()) {
                Task task = queue.poll();
                if (task != null) {
                    task.execute();
                }
            }
        }
    }
}

class Task {

    String name;

    Task(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.println(name + " executed by " + Thread.currentThread().getName());
    }
}