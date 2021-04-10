package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 * @author davewang
 */
public class MajorityElementSolution {

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

    public static void main(String[] args) {
        MajorityElementSolution solution = new MajorityElementSolution();
        int res = solution.majorityElement(new int[]{3,2,3});
        System.out.println(res);
    }




}
