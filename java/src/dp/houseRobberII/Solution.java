package dp.houseRobberII;

/**
 * 213. 打家劫舍 II
 *
 * @author Dave Wang
 */
class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(dp(nums, 0, nums.length - 1), dp(nums, 1, nums.length));
        }
    }

    private int dp(int[] nums, int i, int j) {
        int[] dp = new int[j - i];
        dp[0] = nums[i];
        dp[1] = Math.max(nums[i], nums[i + 1]);
        for (int k = 2; k < j - i; k++) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k + i]);
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 1]);
    }
}