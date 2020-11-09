package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * 创建流的四种方法
 * @Author zp
 * @create 2019/12/10 11:26
 */
public class CreateStreamTest {
    public static void main(String[] args) {
        // 方法一：list.stream
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(10);
        integers.stream();

        // 方法二：Arrays.stream
        Integer[] integers1 = {1, 2, 3, 4};
        Arrays.stream(integers1);

        // 方法三：Stream.of
        Stream.of(1,2,3);
        Stream.of(integers1).forEach(System.out::println);
        Stream.of(integers).forEach(System.out::println);

        // 方法四：Stream.iterate
        Stream.iterate(1, (x) -> x+2).limit(5).forEach(System.out::println);
    }
}
