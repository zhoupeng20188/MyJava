package future;

import java.util.concurrent.*;

/**
 * callable与runable的区别是，它有返回值
 * 用Future接受，取值时用get方法，会阻塞
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(callable);//异步
        System.out.println(submit.get());//阻塞
        executorService.shutdown();
    }
}
