package stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zp
 * @create 2020/11/10 10:29
 */
public class MapTest {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1,"aa",78,1000),
                new User(2,"bb",28,2000),
                new User(3,"cc",38, 3000),
                new User(4,"dd",18, 1000));
        users.stream().map(a -> {
            a.setSalary(a.getSalary()* 2);
            return a;
        }).forEach(System.out::println);
    }
}
