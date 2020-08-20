package bytetest;

/**
 * @Author zp
 * @create 2020/8/20 14:08
 */
public class ByteTest {
    public static void main(String[] args) {
        byte b = (byte)'{';
        System.out.println(b);
        String s = "";
        char[] chars = {'{','}'};
        System.out.println((char)b);
        System.out.println(String.valueOf(chars));
    }
}
