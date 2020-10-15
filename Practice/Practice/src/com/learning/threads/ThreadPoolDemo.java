import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        CustomThreadPool threadPool = new CustomThreadPool(10);
        for(int i=1;i<=10;i++){
            Task task = new Task("Task"+i);
            threadPool.submit(task);
        }
    }

}

class CustomThreadPool {

    int capacity = 5;
    BlockingQueue<Task> queue = new LinkedBlockingQueue<Task>();

    CustomThreadPool(int capacity){
        this.capacity = capacity;
        for(int i=1;i<=capacity;i++){
            CustomThread worker = new CustomThread(queue,"Worker"+i);
            worker.start();
        }
    }

    public void submit(Task task){
        queue.offer(task);
    }
}

class CustomThread extends Thread {

    BlockingQueue<Task> queue;

    CustomThread(BlockingQueue queue, String name){
        this.queue = queue;
        this.setName(name);
    }

    @Override
    public void run() {
        while(true){
            if(!this.queue.isEmpty()){
                Task task = queue.poll();
                if(task != null) {
                    task.execute();
                }
            }
        }
    }
}

class Task {

    String name;

    Task(String name){
        this.name = name;
    }

    public void execute() {
        System.out.println(name+" executed by "+Thread.currentThread().getName());
    }
}