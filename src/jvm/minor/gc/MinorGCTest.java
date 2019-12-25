package jvm.minor.gc;

/**
 * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 * java堆固定为20M，新生代10M,剩下的10M为老年代，新生代中Eden区和Survivor区空间比为8：1
 * 每次GC时，新生代里存活的对象会被移动到survivor的form里，如果超过大小,则进入到老年代
 * survivor的from和to是复制算法要用的两块大小一样的区域，所以新生代可用的空间大小是eden大小+survivor from的大小
 * -XX:PretenureSizeThreshold=3145728 这个参数不能直接写3M 超过这个大小直接进入老年代
 * @Author zp
 * @create 2019/12/25 15:17
 */
public class MinorGCTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        // 由于Eden区只有8M，上面的a1,a2,a3已经占了6M，所以a4需要4M空间不够，发生一次MinorGC
        // 这时发现a1,a2,a3没有需要回收的，而Survivor只有1M，装不下，所以都移动到老年代，所以GC的结果中老年代占4M
        // 新生代空出来后，放入a4,也就是占4M
        a4 = new byte[5 * _1MB]; // 出现一次Minor GC
    }
}
