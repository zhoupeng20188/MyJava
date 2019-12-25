package jvm.minor.gc;

/**
 * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 * java堆固定为20M，新生代10M,剩下的10M为老年代，新生代中Eden区和Survivor区空间比为8：1
 * -XX:MaxTenuringThreshold=1 对象存活多少次后进入老年代
 * -XX:+PrintTenuringDistribution 打印上面设置的相关日志
 * 如果同年的对象大小总和超过了Survivor from的大小的一半，则移动到老年代
 * jdk1.8中移除了永久代的概念，取而代之的是Metaspace，Metaspace里的东西存在内存里，而非虚拟机里
 * @Author zp
 * @create 2019/12/25 15:17
 */
public class ToTenuredGenerationTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] a1, a2, a3;
        a1 = new byte[_1MB / 4];
        a2 = new byte[4 * _1MB];
        // eden区大小为8M，a3实例化时需要4M,发生第一次GC
        // 如果-XX:MaxTenuringThreshold=1,则下次GC时，a1进入老年代
        a3 = new byte[4 * _1MB];
        a3 = null;
        // a3再次实例化时发生第二次GC，
        // 如果-XX:MaxTenuringThreshold=1，此时eden区变为0
        // 如果如果-XX:MaxTenuringThreshold=15，则此时a1还存在于eden区
        a3 = new byte[4 * _1MB];
    }
}
