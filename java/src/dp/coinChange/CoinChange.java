package dp.coinChange;

import java.util.Arrays;

/**
 * @author Dave Wang
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 状态转移
        int[] dp = new int[amount + 1];
        int maxAmount = amount + 1;
        Arrays.fill(dp, maxAmount);
        dp[0] = 0;

        // 先遍历金额
        for (int i = 1; i <= amount; i++) {
            // 再选择硬币面额
            for (int coin : coins) {
                // 当前金额 - 硬币面额 还有剩
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
