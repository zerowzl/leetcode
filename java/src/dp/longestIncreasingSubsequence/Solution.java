package dp.longestIncreasingSubsequence;

/* *****************************************************************************

300. 最长递增子序列
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4
 
示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1

提示：
 1 <= nums.length <= 2500
 -10⁴ <= nums[i] <= 10⁴ 
 
进阶：
 你可以设计时间复杂度为 O(n²) 的解决方案吗？
 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 

*******************************************************************************/

import java.util.Arrays;

/**
 * @author Dave Wang
 */
class Solution {

    /**
     * 动态规划, O(n^2) and O(n)
     * int[] dp 记录当前下标的最大递增子序列长度，默认先填充1
     * 遍历 nums , 找到比当前元素小 并且 最大递增子序列长度 大于等于当前元素的最大递增子序列长度
     * 判断是否大于ans, 是就更新ans
     */
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                // dp[j] >= dp[i] 大于等于当前当前最大递增子序列长度是为了应对 [0, 1, 0, 3, 2, 3] 这种情况
                if (num > nums[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }
}