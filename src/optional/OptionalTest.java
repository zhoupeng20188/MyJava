package optional;

import java.util.Optional;

/**
 * @Author zp
 * @create 2020/11/10 11:16
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Object> o = Optional.ofNullable(null);
//        System.out.println(o.get());
        System.out.println(o.orElse("a"));
        String a = "aaa";
        String b = "bbb";
        System.out.println(o.orElseGet(() -> a.toUpperCase()+b.toUpperCase()));
    }
}
