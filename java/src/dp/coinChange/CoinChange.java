package dp.coinChange;

/* *****************************************************************************

给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。

示例 1：
输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1 

示例 2：
输入：coins = [2], amount = 3
输出：-1 

示例 3：
输入：coins = [1], amount = 0
输出：0

示例 4：
输入：coins = [1], amount = 1
输出：1
 
示例 5：
输入：coins = [1], amount = 2
输出：2

提示：
 1 <= coins.length <= 12
 1 <= coins[i] <= 231 - 1 
 0 <= amount <= 104 

*******************************************************************************/

import java.util.Arrays;

/**
 * @author Dave Wang
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 状态转移表, 长度是 amount+1, value 是需要的硬币数
        int[] dp = new int[amount + 1];
        int maxAmount = amount + 1;
        Arrays.fill(dp, maxAmount);
        dp[0] = 0;

        // 当前金额所需硬币数 = min [(当前金额 - 硬币面值1), (当前金额 - 硬币面值2), (当前金额 - 硬币面值n)] + 1
        // 先遍历金额
        for (int i = 1; i <= amount; i++) {
            // 再选择硬币面额
            for (int coin : coins) {
                // 当前金额 - 硬币面额 还有剩
                if (i - coin >= 0) {
                    // 取比较少的硬币数
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
