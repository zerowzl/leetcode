package queue.maxSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/* *****************************************************************************

239. 滑动窗口最大值
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。

示例 1：
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7

示例 2：
输入：nums = [1], k = 1
输出：[1]

示例 3：
输入：nums = [1,-1], k = 1
输出：[1,-1]

示例 4：
输入：nums = [9,11], k = 2
输出：[11]

示例 5：
输入：nums = [4,-2], k = 2
输出：[4]

提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        // 初始化队列
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            if (deque.isEmpty()) {
                deque.addLast(i);
            } else {
                while (!deque.isEmpty() && num >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            }
        }
        res[0] = nums[deque.peek()];

        // 滑动
        for (int i = k; i < nums.length; i++) {
            // 太老了，移除
            if (deque.peek() <= (i - k)) {
                deque.pop();
            }
            int num = nums[i];
            // 后加的比前面的大，前面的可以直接删除
            while (!deque.isEmpty() && num >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 加入到队列中
            deque.addLast(i);
            // 将队头中的值放入结果中
            res[i - k + 1] = nums[deque.peek()];
        }

        return res;
    }
}
