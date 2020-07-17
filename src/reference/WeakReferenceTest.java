package reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用，只要GC就会强制被回收
 * @Author zp
 * @create 2020/7/17 8:46
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference m = new WeakReference(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        ThreadLocal<M> mThreadLocal = new ThreadLocal<>();
        mThreadLocal.set(new M());
        mThreadLocal.remove();
    }
}
