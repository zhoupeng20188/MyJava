package algorithm.array;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 思路为因为所有数都在0～n-1范围内，所以可以判断值与下标是否对应，如果不对应，则
 * 遍历数组，判断当前下标i与下标的值nums[i]是否相等，相等则继续；
 * 不相等，则判断num[i]与nums[nums[i]]是否相等，如果相等，则说明找到了重复的
 * 交换nums[i]与nums[nums[i]]，重复上述步骤
 * @Author zp
 * @create 2020/12/21 10:56
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 1, 0, 1};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int val = nums[i];
                if (val == nums[val]) {
                    // 找到重复数字
                    return val;
                }
                // 交换
                nums[i] = nums[val];
                nums[val] = val;
            }
        }
        return -1;
    }
}
