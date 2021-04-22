package array.twoSum;

import java.util.HashMap;
import java.util.Map;

/* *****************************************************************************

1.两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

提示：
2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案

*******************************************************************************/


/* *****************************************************************************

题解1：map
x + y = z 我们可以替换成 x = z - y，z 就是target
首先，我们可以使用 map 来存储每次遍历出的值
在遍历的过程中，用 target - 当前值（y），期望得到 x 是多少，去 map 中查找是否存在 x ，存在就返回。
复杂度分析：
时间复杂度：遍历一次 O(n)
空间复杂度：map 需要额外的存储空间，O(n)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }

        // key -> data value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{i, map.get(need)};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }



}
