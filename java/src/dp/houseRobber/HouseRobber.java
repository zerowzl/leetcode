package dp.houseRobber;

/* *****************************************************************************

198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2：
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 400

*******************************************************************************/

import java.util.Arrays;

/**
 * @author Dave Wang
 */
public class HouseRobber {

    // 回溯
    public int robBT(int[] nums) {
        int[][] mem = new int[nums.length][2];
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        return backtrack(nums, 0, 0, mem);
    }

    public int backtrack(int[] nums, int prevStatus, int i, int[][] mem) {
        if (i >= nums.length) {
            return 0;
        }

        // 剪枝
        if (mem[i][prevStatus] > -1) {
            return mem[i][prevStatus];
        }

        int ans;
        if (prevStatus == 1) {
            // 前一个偷家了, 这次只能选择不偷
            ans = backtrack(nums, 0, i + 1, mem);
        } else {
            // 前一个没偷, 这次看看偷和偷谁收获大
            ans = Math.max(nums[i] + backtrack(nums, 1, i + 1, mem),
                    backtrack(nums, 0, i + 1, mem));
        }
        // 备忘录
        mem[i][prevStatus] = ans;
        return ans;
    }

    // 动态规划
    public int robDP(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return Math.max(dp[nums.length - 2], dp[nums.length - 1]);
    }

}
