/**
 * @Author zp
 * @create 2019/12/13 14:06
 */
public class StaticTest {
    static {
        System.out.println("static block print!!!");
        int a= 2;
        boolean b = (a & (1 << 1)) != 0;
        System.out.println(b);
        System.out.println(a | (1 << 2));
    }
}
