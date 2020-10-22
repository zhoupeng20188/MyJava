package algorithm.not.repeat.str;

/**
 * 求a-z字符串中最大无重复子串的长度
 *
 * @Author zp
 * @create 2020/10/22 12:58
 */
public class NotRepeatStrTest {
    public static void main(String[] args) {
        String str = "abcaderwsssvd";
        System.out.println(getMaxSubStrLength(str));
        System.out.println(getMaxSubStr(str));
    }

    /**
     * 求最大子串长度
     * @param str
     * @return
     */
    public static int getMaxSubStrLength(String str) {
        char[] chars = str.toCharArray();

        // 记录字符数据中第i个位置元素上次出现的位置
        // last[0]对应是元素a上次出现的位置
        // last[1]对应是元素b上次出现的位置
        // last[2]对应是元素c上次出现的位置
        // last[25]对应是元素z上次出现的位置
        int[] last = new int[26];
        for (int i = 0; i < last.length; i++) {
            // 一开始初始化为-1
            last[i] = -1;
        }
        // 最大字串长度
        int max = 0;
        // 第i-1个位置的元素的最大子串长度
        int lastMax = 0;
        for (int i = 0; i < chars.length; i++) {
            // 有2个瓶颈，一个是i位置元素上次出现的位置，一个是第i-1位置上元素的最大子串长度
            // 计算两个瓶颈中最小的，即为第i个位置上的最大子串长度
            // last[chars[i] - 'a']为第i个位置元素上次出现的位置
            // lastMax为第i-1位置元素的最大子串长度
            lastMax = Math.min(i - last[chars[i] - 'a'], lastMax + 1);
            max = Math.max(max, lastMax);
            // 更新上次出现位置为现在的位置
            last[chars[i] - 'a'] = i;
        }
        return max;
    }

    /**
     * 求最大子串
     * @param str
     * @return
     */
    public static String getMaxSubStr(String str) {
        char[] chars = str.toCharArray();

        int[] last = new int[26];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }
        int max = 0;
        int lastMax = 0;
        int toIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            lastMax = Math.min(i - last[chars[i] - 'a'], lastMax + 1);
            if (lastMax > max) {
                max = lastMax;
                toIndex = i;
            }
            last[chars[i] - 'a'] = i;
        }

        char[] c = new char[max];
        for(int i = 0; i < max; i++) {
            c[i] = chars[toIndex - max + i + 1];
        }
        return new String(c);
    }
}
