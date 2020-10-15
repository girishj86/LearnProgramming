import java.util.concurrent.*;

public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService  = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new SimpleTask());
        System.out.println(future.isDone());
        if(future.isDone()){
            System.out.println(future.get());
        }
        System.out.println(future.isCancelled());
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        executorService.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println("Executed by "+Thread.currentThread().getName());
                return "Executing new task";
            }
        });
        executorService.shutdown();
    }
}

class SimpleTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" Now I will throw null pointer exception");
        throw new NullPointerException();
    }
}
