package algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 字符串排序
 * a b c
 * a c b
 * b a c
 * b c a
 * c b a
 * c a b
 * 第一轮，a与a交换，b与b交换，c与c交换，得到第一个结果abc
 * 第二轮，a固定，b与c交换，得到第二个结果acb
 * 第三轮，a与b交换，固定b，得到第三个结果，bac
 * 第四轮,固定b，交换a和c，得到第四个结果bca
 * 第五轮，a与c交换，固定c，得到第五个结果cba
 * 第六轮，固定c，交换a和b,得到第六个结果cab
 * @Author zp
 * @create 2021/1/13 17:06
 */
public class SeqString {
    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }
    public static String[] permutation(String s) {
        if(s == null || s.equals("")) return new String[0];
        c = s.toCharArray();
        permutation(0);
        return list.toArray(new String[list.size()]);
    }

    static char[] c;
    static List<String> list = new ArrayList<>();
    public static void permutation(int x) {
        if(x == c.length-1) {
            list.add(new String(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i< c.length; i++){
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            // 交换元素
            swap(i, x);
            // 递归，从下一位开始
            permutation(x+1);
            // 恢复元素
            swap(i, x);
        }
    }

    public static void swap(int i, int x){
        char tmp = c[i];
        c[i] = c[x];
        c[x] = tmp;
    }
}
