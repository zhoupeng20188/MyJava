package algorithm.array;

/**
 * 数组中最小的k个数
 * @Author zp
 * @create 2021/1/5 15:28
 */
public class FindMinK {
    public static void main(String[] args) {
        int[] nums = {11,3,10,5,4,7};
        final int[] minK = findMinK(nums, 3);
        System.out.println(minK);
    }
    public static int[] findMinK(int[] nums, int k){
        quickSort(nums, 0, nums.length-1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static void quickSort(int[] nums, int start, int end, int k){
        if(start >= end) {
            return;
        }
        int index= partition(nums, start, end);
        if(index == k-1) return;
        if(index < k-1) quickSort(nums, index+1, end, k);
        if(index > k-1) quickSort(nums, start, index-1, k);
    }

    public static int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int mark = start;
        for (int i = start+1; i <= end; i++) {
            if(nums[i] < pivot) {
                mark++;
                swap(nums, i, mark);
            }
        }
        swap(nums,mark,start);
        return mark;
    }
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
