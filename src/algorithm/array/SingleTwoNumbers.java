package algorithm.array;

/**
 * 数组中只有2个数字出现一次
 * @Author zp
 * @create 2020/12/30 11:32
 */
public class SingleTwoNumbers {
    public static void main(String[] args) {
        int[] nums = {3,2,1,3};
        System.out.println(singleNumbers(nums));
    }

    public static int[] singleNumbers(int[] nums) {
        int tmp = nums[0];
        for(int i=1; i< nums.length; i++){
            tmp ^= nums[i];
        }
        int bit = firstBit1(tmp);
        int[] nums1 = new int[nums.length];
        int[] nums2 = new int[nums.length];
        int i1=0;
        int i2=0;
        for(int i=0; i< nums.length; i++){
            if(isBit1(nums[i], bit)) {
                nums1[i1++] = nums[i];
            } else {
                nums2[i2++] = nums[i];
            }
        }
        int[] result = new int[2];
        tmp = nums1[0];
        for(int i=1; i< i1; i++){
            tmp ^= nums1[i];
        }
        result[0] = tmp;
        tmp = nums2[0];
        for(int i=1; i< i2; i++){
            tmp ^= nums2[i];
        }
        result[1] = tmp;

        return result;
    }

    public static int firstBit1(int n) {
        int bit = 0;
        while((n & 1) == 0){
            bit++;
            n = n>>1;
        }
        return bit;
    }

    public static boolean isBit1(int n, int x){
        return (n>>x & 1) == 1?true:false;
    }
}
