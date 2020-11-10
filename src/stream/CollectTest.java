package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author zp
 * @create 2020/11/10 10:06
 */
public class CollectTest {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1,"aa",78,1000),
                new User(2,"bb",28,2000),
                new User(3,"cc",38, 3000),
                new User(4,"dd",18, 1000));
        // 求平均值
        System.out.println(users.stream().collect(Collectors.averagingInt(User::getAge)));
        // 分组
        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getSalary));
        System.out.println(collect);
    }
}
