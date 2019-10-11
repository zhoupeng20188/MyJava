package threadpool.exception.none;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zp
 * @create 2019/10/11 10:42
 */
public class MyThreadPoolException {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "执行");
                Object o = null;
                System.out.println(o.toString());
            });
        }

    }
}
