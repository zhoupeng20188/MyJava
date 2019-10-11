package threadpool.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zp
 * @create 2019/10/10 14:31
 */
public class NewSingleThreadPool {
    public static void main(String[] args) {
        // 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在被执行,打印的值是:" + index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
