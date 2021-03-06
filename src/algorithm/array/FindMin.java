package algorithm.array;

/**
 * 查找旋转数组中的最小值
 * 使用变种的二分查找，使用两个指针，开始时分别指向数组的第一个元素和最后一个元素
 * 然后计算数组的中间位置，与第一个元素比较，如果大于，则说明应该向右查找，移动left指针
 * 如果小于，则说明应该向左查找，移动right指针
 * 当left指针=right指针-1时，right指针即为结果
 *
 * @Author zp
 * @create 2020/12/23 12:35
 */
public class FindMin {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[right] > arr[left] || right == left) {
            // 普通升序数组或只有一个元素的数组
            return arr[left];
        }
        int middle = 0;
        while(left < right){
            middle = (right-left)/2 + left;
            if(arr[middle] > arr[right]){
                // 右移
                left = middle + 1;
            } else if(arr[middle] < arr[right]){
                // 左移
                right = middle;
            } else {
                right--;
            }
        }
        return arr[left];
    }
}
