package heap.findKthLargest;

/* *****************************************************************************

215. 数组中的第 K 大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4 

说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
Related Topics 堆 分治算法

*******************************************************************************/

/* *****************************************************************************

题解：
使用小顶堆

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(k)

*******************************************************************************/

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Dave Wang
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 创建一个小顶堆，Java中的堆是优先队列
        Queue<Integer> head = new PriorityQueue<>(k);
        for (int num : nums) {
            // 未满，直接放入
            if (head.size() < k) {
                head.add(num);
                continue;
            }
            // 满了就需要传入的值比堆顶值大才能放入堆中
            if (num > head.peek()) {
                head.poll();
                head.add(num);
            }
        }

        // 返回堆顶元素就可以
        return head.peek();
    }


}
