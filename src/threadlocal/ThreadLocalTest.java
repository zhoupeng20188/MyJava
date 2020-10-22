package threadlocal;

/**
 * threadLocal天然线程私有
 * @Author zp
 * @create 2020/10/22 10:22
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(2000);
                System.out.println(threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                threadLocal.set("sdfdsfds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
