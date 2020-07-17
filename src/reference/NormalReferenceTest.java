package reference;

import java.io.IOException;

/**
 * 强引用，当对象没有引用时,GC会被回收
 * @Author zp
 * @create 2020/7/17 8:39
 */
public class NormalReferenceTest {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();
        System.in.read();
    }
}
