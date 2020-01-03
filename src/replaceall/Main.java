package replaceall;

/**
 * @Author zp
 * @create 2020/1/3 11:56
 */
public class Main {
    public static void main(String[] args) {
        String aa = "    34232";
        aa = aa.replaceAll(" ", "&nbsp;");
        System.out.println(aa);
    }
}
