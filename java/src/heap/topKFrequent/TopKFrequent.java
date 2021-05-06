package heap.topKFrequent;

/* *****************************************************************************

347. 前 K 个高频元素
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1] 

提示：
1 <= nums.length <= 105
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的

进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。

*******************************************************************************/

/* *****************************************************************************

题解：
先遍历数组，统计元素出现次数；
构建 k 大小的小顶堆，堆内元素类型使用 数组，数组第一个元素是数值，第二个元素是数值出现的次数，排序规则：比较出现次数；
让堆中插入；
根据堆构建返回结果。

复杂度分析：
时间复杂度：首先，遍历一次数组的时间复杂度是 O(n)；
随后，遍历「出现次数数组」，由于堆的大小至多为 k，因此每次堆操作需要 O(log k) 的时间，共需 O(N log k) 的时间。
二者之和为 O(N log k)。
空间复杂度：O(N)。哈希表的大小为 O(N)，而堆的大小为 O(k)，共计为 O(N)。

*******************************************************************************/

import java.util.*;

/**
 * @author Dave Wang
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // 统计元素出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 构建一个小顶堆，堆内存的是元素和元素出现次数
        Queue<int[]> head = new PriorityQueue<>(k, Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (head.size() < k) {
                head.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > head.peek()[1]) {
                    head.poll();
                    head.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        // 取出堆中元素数组的第一位构建返回结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = head.poll()[0];
        }
        return res;
    }

}
