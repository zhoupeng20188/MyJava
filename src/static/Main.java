import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zp
 * @create 2019/12/13 14:09
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // 调用Class.forName时会自动执行类的static代码块
        Class.forName("StaticTest");
        AtomicInteger a = new AtomicInteger(0);
        a.getAndIncrement();
    }
}
