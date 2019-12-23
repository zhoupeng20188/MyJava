package asList;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zp
 * @create 2019/12/23 17:57
 */
public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3");
        // 用Arrays.asList返回的list，不能调用以下操作，否则会报错UnsupportedOperationException
        // 这是因为Arrays.asList里的ArrayList并不是我们熟悉的ArrayList类，
        // 而是一个内部类，里面并没有clear,add等方法，所以会报错
        strings.clear();
        strings.add("34");
    }
}
