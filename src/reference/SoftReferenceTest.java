package reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * 需要设置堆内存为20M来测试 -Xmx20M
 * @Author zp
 * @create 2020/7/17 15:00
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        // gc时不会回收
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(m.get());
        // 堆内存不够新分配内存时会回收软引用
        byte[] bytes = new byte[1024 * 1024 * 12];
        System.out.println(m.get());
    }
}
