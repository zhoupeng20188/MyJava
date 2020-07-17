package reference;

/**
 * @Author zp
 * @create 2020/7/17 8:40
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
