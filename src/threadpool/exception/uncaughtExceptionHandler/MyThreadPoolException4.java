package threadpool.exception.uncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @Author zp
 * @create 2019/10/11 10:42
 */
public class MyThreadPoolException4 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(
                        new Thread.UncaughtExceptionHandler() {
                            @Override
                            public void uncaughtException(Thread t1, Throwable e) {
                                System.out.println(t1.getName() + "线程抛出的异常" + e);
                            }
                        });
                return t;
            }
        });
        threadPool.execute(()->{
            Object object = null;
            System.out.print("result## " + object.toString());
        });

    }
}
