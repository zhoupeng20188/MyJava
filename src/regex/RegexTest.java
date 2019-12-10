package regex;

import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        // 匹配所有html标签
        String regex = "<.*?>";
        String s = "<img>bbb<a>sdfsf</a>";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(s);
//        for (int i = 0; i < matcher.groupCount(); i++) {
//            System.out.println(matcher.group(i));
//        }
        // 取得所有匹配结果
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println(Pattern.matches(regex,s));
        // 直接使用String类的匹配方法
        System.out.println(s.matches(regex));
        // 直接使用String类的替换方法
        System.out.println(s.replaceAll(regex,""));
    }
}
