package dp.coinChange;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class CoinChangeTest {

    private CoinChange solution = new CoinChange();

    @Test
    public void coinChange() {
        int[] coins = {2, 3, 5};
        assertEquals(2, solution.coinChange(coins, 10));
        assertEquals(3, solution.coinChange(coins, 11));
        assertEquals(-1, solution.coinChange(coins, 1));
    }
}