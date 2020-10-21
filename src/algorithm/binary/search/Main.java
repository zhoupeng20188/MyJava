package algorithm.binary.search;

/**
 * 二分查找
 * @Author zp
 * @create 2020/10/21 11:09
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        System.out.println(binarySearch(nums, 1));
    }

    private static int binarySearch(int[] nums, int target){
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int mid =0;
        while (left <= right){
            // 计算中间位置
            mid = (right -left) / 2 + left;
            if(target > nums[mid]) {
                // 如果目标值>中间位置值时，left移动到中间位置+1
                left = mid + 1;
            } else {
                // 反之将right移动到中间位置-1
                right = mid -1;
            }
        }
        // 当跳出循环时，left即为目标位置
        return left;
    }
}
