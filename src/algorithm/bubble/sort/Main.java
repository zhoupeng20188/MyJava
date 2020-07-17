package algorithm.bubble.sort;

import java.util.Arrays;

/**
 * @Author zhoupeng
 * @Date 2020-05-14 17:21
 */
public class Main {
    public static void main(String[] args) {
        int[] test = {1, 34, 23, 5, 6, 9, 21, 33};
        // 最原始的冒泡排序
        bubble(test);
        // 第一次改进
        // 如果某一次循环中没有发生交换，说明是有序的，就可以直接退出了
        int[] test2 = {1, 34, 23, 5, 6, 9, 21, 33};
        bubble2(test2);

        // 第二次改进
        // 记录最后一次发生交换的下标，设定有序边界，只用在有序边界内循环即可
        int[] test3 = {1, 34, 23, 5, 6, 9, 21, 33};
        bubble2(test3);

    }

    /**
     * 最原始的冒泡排序
     *
     * @param test
     */
    private static void bubble(int[] test) {
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length - 1 - i; j++) {
                int tmp = test[j];
                if (tmp > test[j + 1]) {
                    test[j] = test[j + 1];
                    test[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(test));
    }

    /**
     * 第一次改进
     * 如果某一次循环中没有发生交换，说明是有序的，就可以直接退出了
     *
     * @param test
     */
    private static void bubble2(int[] test) {
        for (int i = 0; i < test.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < test.length - 1 - i; j++) {
                int tmp = test[j];
                if (tmp > test[j + 1]) {
                    test[j] = test[j + 1];
                    test[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        
        System.out.println(Arrays.toString(test));
    }

    /**
     * 第二次改进
     * 如果右边的几个值是有序的，程序每次还是会比较所有值
     * 可以设定有序区间，区间内的值不比较
     *
     * @param test
     */
    private static void bubble3(int[] test) {
        // 最后一次发生交换的下标
        int lastExchangeIndex = 0;
        // 有序边界下标
        int sortBorder = test.length - 1;
        for (int i = 0; i < test.length; i++) {
            boolean isSorted = true;
            // 只用在有序边界内循环即可
            for (int j = 0; j < sortBorder; j++) {
                int tmp = test[j];
                if (tmp > test[j + 1]) {
                    test[j] = test[j + 1];
                    test[j + 1] = tmp;
                    isSorted = false;
                    // 记录最后一次发生交换的下标
                    lastExchangeIndex = j;
                }
            }
            // 设定有序边界
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(test));
    }
}
