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

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Dave Wang
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // 统计元素出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        // 构建一个小顶堆，堆内存的是元素出现的次数
        Queue<Integer> head = new PriorityQueue<>(k);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (head.size() < k) {
                head.add(entry.getValue());
            } else {
                if (entry.getValue() > head.peek()) {
                    head.poll();
                    head.add(entry.getValue());
                }
            }
        }

        int[] res = new int[k];
        int i = 0;
        // 循环删除堆顶元素
        while (!head.isEmpty()) {
            Integer poll = head.poll();
            // 如果统计 map 的中出现元素次数和堆顶元素一致，就将 key（元素值）加入到返回结果中，
            // 并跳出循环（防止出现元素出现次数相同导致重复添加）
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue().equals(poll)) {
                    res[i] = entry.getKey();
                    i++;
                    countMap.remove(entry.getKey());
                    break;
                }
            }
        }

        return res;
    }

}
