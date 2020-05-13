package bitmap;

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
    }
}
