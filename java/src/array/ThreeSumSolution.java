package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @author davewang
 */
public class ThreeSumSolution {

    /**
     * 排序 + 双指针
     * 时间复杂度：排序 O(nlogn) 两重循环 O(n^2)
     * 空间复杂度：排序 O(logn)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>(0);
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int first = 0; first < nums.length; first++) {
            // 过滤重复数据
            if (first > 0 && nums[first] == nums[first -1]) {
                continue;
            }

            // 第三个指针，从后往前
            int third = nums.length - 1;
            // 要找的目标值
            int target = -nums[first];
            
            // 第二层循环
            for (int second = first + 1; second < nums.length; second++) {
                // 过滤重复数据
                if (second > first + 1 && nums[second] == nums[second -1]) {
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

    public static void main(String[] args) {
        ThreeSumSolution solution = new ThreeSumSolution();
        List<List<Integer>> res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }
}
