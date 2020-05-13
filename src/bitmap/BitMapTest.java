package bitmap;

/**
 * 对于int类型的整数移位a<<b或 a>>b，系统先用b对32求余，
 * 得到的结果才是真正移位的位数
 *
 * 对于long类型的整数移位，问同上，不过是对64求余
 */
public class BitMapTest {
    public static void main(String[] args) {
        int a = 1;
        long b = 1L;
        int c = 32;
        int d = 64;
        int e = 65;
        System.out.println(a >> 6);
        System.out.println(b >> 6);
        System.out.println(a << 32);
        System.out.println(b << 32);
        System.out.println(c >> 6);
        System.out.println(d >> 6);
        System.out.println(e>>6);
        System.out.println((3>>6) | (b << 3));
        System.out.println((65>>6) | (b << 65));
        System.out.println((129>>6) | (b << 129));
        System.out.println((257>>6) | (b << 257));
        System.out.println("----------");
        System.out.println(3>>6);
        System.out.println(61>>6);
        System.out.println(66>>6);
        System.out.println(67>>6);
        System.out.println(1L<<65);
        System.out.println(1L<<64);
        System.out.println(1L<<63);
        System.out.println(1L<<128);
        System.out.println(1L<<129);
        System.out.println(1L<<257);
        System.out.println("------------");
        System.out.println(1<<31);
        System.out.println(1<<32);
        System.out.println(1<<33);
        System.out.println(1<<34);
        System.out.println(2>>32);
        System.out.println(2>>33);
        System.out.println(2>>34);
    }
}
