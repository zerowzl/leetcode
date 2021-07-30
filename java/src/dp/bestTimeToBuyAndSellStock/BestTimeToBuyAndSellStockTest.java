package dp.bestTimeToBuyAndSellStock;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

    @Test
    public void maxProfit() {
        Assert.assertEquals(5, solution.maxProfitBruteForce(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0, solution.maxProfitBruteForce(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void maxProfitDP() {
        Assert.assertEquals(5, solution.maxProfitDP(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0, solution.maxProfitDP(new int[]{7, 6, 4, 3, 1}));
    }
}
