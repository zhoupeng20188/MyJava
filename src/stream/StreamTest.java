package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @Author zp
 * @create 2019/12/10 11:26
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 30, 50, 60, 90, 100, 140, 150);
        Stream<Integer> integerStream = integers.stream().filter(i -> i < 100);
//        integerStream.forEach(i -> System.out.println(i));
        integerStream.forEach(System.out::println);
        integers.stream().filter(i -> i < 100).map(i -> i * 2).forEach(System.out::println);
        Integer integer = integers.stream().filter(i -> i < 100).map(i -> i * 2).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).get();
        // lambda表达式写法
        Integer integer1 = integers.stream().filter(i -> i < 100).map(i -> i * 2).reduce((a, b) -> a + b).get();
        System.out.println("sum is " + integer);
        System.out.println("sum is " + integer1);
    }
}
