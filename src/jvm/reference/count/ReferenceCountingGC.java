package jvm.reference.count;

/**
 * vm参数：-Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Author zp
 * @create 2019/12/24 16:30
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 唯一意义就是占点内存,以便能在GC日志中看清楚是否回收
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();
        a.instance = b;
        b.instance = a;
        a = null;
        b = null;
        //从GC日志里可以看出对象被回收了，从侧面说明虚拟机不是通过引用计数法判断对象是否存活
        System.gc();
    }
}
