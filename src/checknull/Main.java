package checknull;

import java.util.Objects;

/**
 * @Author zp
 * @create 2020/6/12 16:59
 */
public class Main {
    public static void main(String[] args) {
        new Main().test(null);
    }
    private void test(String a){
        Objects.requireNonNull(a,"a can't be null!");
        System.out.println(a);
    }
}
