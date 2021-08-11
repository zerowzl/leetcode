package array.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* *****************************************************************************
15.三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：
输入：nums = []
输出：[]

示例 3：
输入：nums = [0]
输出：[]
 
提示：
 0 <= nums.length <= 3000
 -105 <= nums[i] <= 105 

*******************************************************************************/

/* *****************************************************************************

题解：
排序 + 双指针

复杂度分析：
时间复杂度：排序 O(nlogn) 两重循环 O(n^2)
空间复杂度：排序 O(logn)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int first = 0; first < nums.length; first++) {
            // 过滤重复数据
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            // 第三个指针，从后往前
            int third = nums.length - 1;
            // 要找的目标值
            int target = -nums[first];

            // 第二层循环
            for (int second = first + 1; second < nums.length; second++) {
                // 过滤重复数据
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 如果大于目标值，就移动第三个指针向前
                while (second < third && (nums[second] + nums[third] > target)) {
                    third--;
                }

                // 指针重合，说明没找到
                if (second == third) {
                    break;
                }

                // 找到了
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }

        return res;
    }
}
