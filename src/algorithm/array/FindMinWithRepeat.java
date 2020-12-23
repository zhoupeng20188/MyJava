package algorithm.array;

/**
 * 查找旋转数组中的最小值(数组中可能有重复元素)
 * 使用变种的二分查找，使用两个指针，开始时分别指向数组的第一个元素和最后一个元素
 * 规律是，最小值右边的元素一定小于等于最后一个元素，最小值左边的元素一定大于等于最后一个元素
 * 然后计算数组的中间位置，与第最后一个元素比较，如果大于，则说明是最小元素左边的元素，需要向右找，移动left指针到middle+1位置
 * 如果小于，则说明是最小元素右边的元素，需要向左找，移动right指针到middle
 * 如果等于，判断不了是最小元素左边还是右边的元素，因为有重复，所以直接将这个元素去除，right指针-1
 * 当left=right时，left指针即为结果
 *
 * @Author zp
 * @create 2020/12/23 12:35
 */
public class FindMinWithRepeat {
    public static void main(String[] args) {
//        int[] arr = {2,2,2,0,1};
        int[] arr = {10,1,10,10,10};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left] || left == right) {
            // 普通升序数组
            return nums[left];
        }
        int middle = 0;
        while(left < right){
            middle = (right-left)/2 +left;
            if(nums[middle] > nums[right]){
                // 向右查找
                left = middle + 1;
            } else if(nums[middle] < nums[right]){
                // 向左查找
                right = middle;
            } else {
                // 向左移一位
                right = right -1;
            }
        }
        return nums[left];
    }
}
