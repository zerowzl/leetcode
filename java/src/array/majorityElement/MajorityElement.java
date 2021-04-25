package array.majorityElement;

import java.util.HashMap;
import java.util.Map;

/* *****************************************************************************

169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1：
输入：[3,2,3]
输出：3 

示例 2：
输入：[2,2,1,1,1,2,2]
输出：2

进阶：
尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

*******************************************************************************/

/* *****************************************************************************

题解：
通过 map 来存储元素和元素出现的次数。
遍历数组，包含就 +1 put，然后判断 count 是否过半，过半就返回；不包含就 put 1。

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class MajorityElement {
    
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int target = nums.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                count++;
                map.put(num, count);
                if (count >= target) {
                    return num;
                }
            } else {
                map.put(num, 1);
            }
        }
        return Integer.MIN_VALUE;
    }
}
