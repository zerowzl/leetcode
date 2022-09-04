package array.slidingWindowMaximum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 */
class Solution {

    /**
     * 单调队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满前面的元素
                queue.push(nums[i]);
            } else {
                // 扩大窗口
                queue.push(nums[i]);
                // 获取最大值
                res.add(queue.max());
                // 移除旧的最大值
                queue.pop(nums[i - k + 1]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 单调队列
     */
    class MonotonicQueue {
        // 双向链表, 最大队列
        private LinkedList<Integer> maxQueue;
        // 容量
        public MonotonicQueue() {
            this.maxQueue = new LinkedList<>();
        }

        public void push(int n) {
            while (!maxQueue.isEmpty() && maxQueue.getLast() < n) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(n);
        }

        public int max() {
            return maxQueue.getFirst();
        }

        public void pop(int n) {
            if(n == maxQueue.getFirst()) {
                maxQueue.removeFirst();
            }
        }
    }
}