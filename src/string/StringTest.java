package string;

/**
 * 如果是常量拼接，比如"a" + "b",直接将结果放到字符串常量池中
 * 如果有变量拼接，比如 s1 + "b",结果是放在堆中，而不是字符串常量池中
 * @Author zp
 * @create 2020/8/14 10:42
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "a" + "b";
        String s2 = "ab";
        System.out.println(s1 == s2); //true

        String s3 = "cd";
        String s4 = "e";
        String s5 = s3 + s4;
        String s6 = "cde";
        System.out.println(s5 == s6); // false

        String s7 = s5.intern();
        System.out.println(s6 == s7); //true


        String s = new String("a1") + new String("a2");
        // 在上一行代码执行完后，字符串常量池中并没有"a1a2"
        String ss = s.intern(); // jdk1.6中，在字符串常量池中创建一个字符串"a1a2"
                                // jdk1.7,1.8中，不会在字符串常量池中创建字符串"a1a2"，而是创建一个引用，指向new String("a1a2")
        System.out.println(s == "a1a2");
        System.out.println(ss == "a1a2");
    }
}
