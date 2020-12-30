package algorithm.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zp
 * @create 2020/12/30 16:52
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] nums = {1,-1};
        int[] nums = {7, 2, 4};
        int[] res = maxSlidingWindow(nums, 2);
        System.out.println(res);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        int winSize = 0;
        int cnt = 0;
        // 定义一个双端队列
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (winSize < k) winSize++;
            if (queue.size() == 0) {
                // 入队
                queue.offerLast(i);
            } else if (queue.size() > 0 && winSize < k && nums[i] < nums[queue.peekFirst()]) {
                // 入队
                queue.offerLast(i);
            } else if (queue.size() > 0 && winSize < k && nums[i] >= nums[queue.peekFirst()]) {
                // 队列全部元素出队，当前元素入队
                while (queue.size() > 0) queue.pollFirst();
                queue.offerLast(i);
            } else if (queue.size() > 0 && winSize == k && nums[i] < nums[queue.peekFirst()]) {
                while (nums[i] > nums[queue.peekLast()]) {
                    // 队列末尾小于当前元素的所有出队
                    queue.pollLast();
                }
                // 当前元素入队
                queue.offerLast(i);
            } else if (queue.size() > 0 && winSize == k && nums[i] >= nums[queue.peekFirst()]) {
                // 队列全部元素出队，当前元素入队
                while (queue.size() > 0) queue.pollFirst();
                queue.offerLast(i);
            }
            // 判断队列中第一个元素是否已超过滑动窗口需要出队
            if (queue.size() > 0 && i - queue.peekFirst() >= k) {
                // 出队
                queue.pollFirst();
            }
            if (winSize == k) {
                res[cnt++] = nums[queue.peekFirst()];
            }

        }
        return res;
    }
}
