package cacheline;

/**
 * @Author zp
 * @create 2020/9/8 10:01
 */
public class WithoutCachelinePadding {
    private static class T {
        private volatile long x;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                arr[1].x = i;
            }
        });
        long l = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
