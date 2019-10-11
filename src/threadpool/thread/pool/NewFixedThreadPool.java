package threadpool.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zp
 * @create 2019/10/10 14:03
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        // 创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在执行");
            });
        }
    }
}
