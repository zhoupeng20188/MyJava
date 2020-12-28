package algorithm.array;

/**
 * 数组中的逆序对
 *
 * @Author zp
 * @create 2020/12/28 16:25
 */
public class ReversePairs {
    public static void main(String[] args) {
//        int[] nums = {7,5,6,4};
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        return reversePairs(nums, copy, 0, nums.length - 1);
    }

    public static int reversePairs(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }

        int middle = start + (end - start) / 2;
        int left = reversePairs(copy, nums, start, middle);
        int right = reversePairs(copy, nums, middle + 1, end);
        int cnt = 0;
        int i = middle;
        int j = end;
        int indexCopy = end;
        // 从两个数组的末尾开始比较
        while (i >= start && j >= middle + 1) {
            if (nums[i] > nums[j]) {
                copy[indexCopy] = nums[i];
                i--;
                indexCopy--;
                // 将右边数组的目标元素左边的全部元素统计加1
                cnt = cnt + j - middle;
            } else {
                copy[indexCopy] = nums[j];
                j--;
                indexCopy--;
            }
        }

        // 将两个数组中剩余的元素加入copy数组中
        for (; i >= start; i--) {
            copy[indexCopy] = nums[i];
            indexCopy--;
        }
        for (; j >= middle + 1; j--) {
            copy[indexCopy] = nums[j];
            indexCopy--;
        }

        return left + right + cnt;
    }
}
