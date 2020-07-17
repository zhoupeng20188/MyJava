package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sdfsd");
        list.add("bbfsaa");
        list.forEach(System.out::println);
        list.forEach(s -> System.out.println(s + "34343"));

        // lambda表达式本质上是一个接口实现类的代码，所以其返回值是一个接口类
        MyLambdaInterface myLambdaInterface = (s) -> System.out.println(s + "ggggg");
        myLambdaInterface.show("234234");

        List<Person> personList = new ArrayList<>();
        Person person = new Person("zhangsan", 10);
        Person person2 = new Person("lisi", 10);
        personList.add(person);
        personList.add(person2);
        checkAndExecute(personList,
                p -> "zhangsan".equals(p.getName()),
                p -> System.out.println(p.getName() + "acc by lambda"));
        // 上面写法等价于下面的stream写法
        personList.stream().filter(p -> "zhangsan".equals(p.getName()))
                .forEach(p -> System.out.println(person.getName() + "acc by stream"));
    }

    public static void checkAndExecute(List<Person> list,
                                       Predicate<Person> personPredicate,
                                       Consumer<Person> consumer) {
        list.forEach(person -> {
            if (personPredicate.test(person)) {
                consumer.accept(person);
            }
        });
    }
}
