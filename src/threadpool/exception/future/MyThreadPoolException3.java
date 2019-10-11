package threadpool.exception.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author zp
 * @create 2019/10/11 10:42
 */
public class MyThreadPoolException3 {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future<?> future = fixedThreadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "执行");
                Object o = null;
                System.out.println(o.toString());
            });
            try {
                future.get();
            } catch (Exception e) {
                System.out.println("发生异常");
            }
        }

    }
}
