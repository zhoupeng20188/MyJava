package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author zp
 * @create 2020/11/10 10:02
 */
public class SortedTest {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1,"aa",78,1000),
                new User(2,"bb",28,2000),
                new User(3,"cc",38, 3000),
                new User(4,"dd",28, 1000));
        users.stream().map(User::getAge).sorted().forEach(System.out::println);
        System.out.println("==================");
        // 按年龄倒序，加返回值前面加上-即可。
        users.stream().map(User::getAge).sorted((a,b)-> -Integer.compare(a,b)).forEach(System.out::println);
        // 先按年龄排序(倒序)，年龄相同，按工资排序（倒序）
        Stream<User> sorted = users.stream().sorted((a, b) -> {
            if (a.getAge() == b.getAge()) {
                // 年龄相同时
                return -Integer.compare(a.getSalary(), b.getSalary());
            } else {
                // 年龄不相同时
                return -Integer.compare(a.getAge(), b.getAge());
            }
        });
        sorted.forEach(System.out::println);
    }
}
