package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 *
 * @author Dave Wang
 */
public class TwoSum {

    /**
     * 解题思路：题目要求和为 target，那么就需要对两个数进行求和再比较。最符合直觉的方式是双层循环，但复杂度比较高。
     * 那么有没有一种 O(1) 的查询复杂度的数据结构来存储遍历过的值？Map！
     * <p>
     * 执行过程：
     * 一次遍历，遍历过程中从 Map 中获取 （target - int[currentIndex] )，有直接返回；没有则将 值: 索引 存入 map。
     *
     * @param nums   int 数组
     * @param target 目标值
     * @return 和为 target 两个元素的数组索引
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            Integer val = map.get(difference);
            if (val != null) {
                return new int[]{i, val};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
