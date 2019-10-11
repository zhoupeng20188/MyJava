package threadpool.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zp
 * @create 2019/10/10 14:03
 */
public class NewCacheThreadPool {
    public static void main(String[] args) {
        // 可缓存线程池，先查看池中有没有以前建立的线程，
        // 如果有，就直接使用。如果没有，就建一个新的线程加入池中，
        // 缓存型池子通常用于执行一些生存期很短的异步型任务
        // 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            cacheThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()+"正在执行"));
        }
    }
}
