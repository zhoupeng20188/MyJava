package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 核心思想是选一个基准数（一般为左边第一个）
 * 然后将整个数组分为两块，左路都是小于基准数的，右边都是大于基准数的
 * 然后再在分好的两块中再继续此过程
 * 直到无法再分为止
 * 时间复杂度，最坏为O(n的平方），一般为O(nlogn)
 *
 * @Author zp
 * @create 2020/12/9 9:15
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 5, 1, 7, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归终止条件
        while (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素下标
        int index = partition(arr, startIndex, endIndex);
        // 左边部分递归排序
        quickSort(arr, startIndex, index - 1);
        // 右达部分递归排序
        quickSort(arr, index + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        // 选一个元素为基准元素
        int pivot = arr[startIndex];
        // 指针
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            int now = arr[i];
            if (now < pivot) {
                // 当前位置元素小于基准元素时，指针右移，并将指针所指向的元素和当前元素交换
                // 因为指针左边（包括指针）都代表小于基准元素的区域
                mark++;
                // 交换
                arr[i] = arr[mark];
                arr[mark] = now;
            }
        }
        // 将基准元素与mark指针位置的元素交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
