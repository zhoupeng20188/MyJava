package checkNull;

import java.util.Objects;

/**
 * @Author zhoupeng
 * @Date 2020-05-09 11:55
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().add(1, 3));
        new Main().add(null, null);
    }
    private int add(Integer a, Integer b){
        int aa = Objects.requireNonNull(a, "a不能为空");
        int bb = Objects.requireNonNull(b, "b不能为空");
        return aa + bb;
    }
}
