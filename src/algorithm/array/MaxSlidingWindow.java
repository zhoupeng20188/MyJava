package algorithm.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author zp
 * @create 2020/12/30 16:52
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] nums = {1,-1};
//        int[] nums = {7, 2, 4};
        int[] nums = {5183,2271,3067,539,8939,2999,9264,737,3974,5846,-210,9278,5800,2675,6608,1133,
                -1,6018,9672,5179,9842,7424,-209,2988,2757,5984,1107,2644,-499,7234,7539,6525,347,5718,
                -742,1797,5292,976,8752,8297,1312,3385,5924,2882,6091,-282,2595,96,1906,8014,7667,5895,
                7283,7974,-167,7068,3946,6223,189,1589,2058,9277,-302,8157,8256,5261,8067,1071,9470,2682,
                8197,5632,753,3179,8187,9042,8167,4657,7080,7801,5627,7917,8085,928,-892,-427,3685,4676,
                2431,8064,8537,343,505,4352,2108,4399,66,2086,1922,9126,9460,393,443,5689,7595,850,8493,
                2866,732,3738,7933,3666,2370,5804,4045,7903,8009,5387,5542,7593,6862,1547,6934,-160,9693,
                4560,7429,9989,7232,-594,587,6476,9277,4471,5979,6268,2419,6706,-727,1927,7361,9684,5519,
                2703,1723,5181,3545,4290,9421,4288,1656,1541,9632,1448,-490,4747,5416,4139,-845,3834,3349,
                8594,7882,2279,7777,9369,9917,8167,6799,-612,5604,5787,2615,7033,5986,-322,8631,1793,-612,
                3528,206,419,1413,8585,5658,-981,1391,8088,7035,6259,-651,3118,9105,4531,2569,7576,7981,838};
        int[] res = maxSlidingWindow(nums, 100);
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
                while (nums[i] > nums[queue.peekLast()]) {
                    // 队列末尾小于当前元素的所有出队
                    queue.pollLast();
                }
                // 当前元素入队
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
