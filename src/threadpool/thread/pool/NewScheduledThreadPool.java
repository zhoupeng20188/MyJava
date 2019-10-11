package threadpool.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author zp
 * @create 2019/10/10 14:03
 */
public class NewScheduledThreadPool {
    public static void main(String[] args) {
        // 创建一个定长线程池，支持定时及周期性任务执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        // 延迟1秒执行
        scheduledThreadPool.schedule((Runnable) () -> System.out.println("延迟1秒执行"),1L, TimeUnit.SECONDS);
        // 延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate((Runnable) () -> System.out.println("延迟1秒后每3秒执行一次"),1L,3L, TimeUnit.SECONDS);
    }
}
