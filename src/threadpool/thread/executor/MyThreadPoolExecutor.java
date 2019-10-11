package threadpool.thread.executor;

import java.util.concurrent.*;

/**
 * @Author zp
 * @create 2019/10/10 14:35
 */
public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        // 创建数组型缓冲等待队列
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(8);
        // 设置拒绝策略
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + "is discard!!");
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.SECONDS, bq, Executors.defaultThreadFactory(), rejectedExecutionHandler);
        // 从运行结果可以看到，10任务被执行（因为线程池有5个线程，缓存队列也能缓存5个），10任务被丢弃，符合我们预期。
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(() -> {System.out.println(System.currentTimeMillis() + ": Thread ID: " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } });
        }
    }
}
