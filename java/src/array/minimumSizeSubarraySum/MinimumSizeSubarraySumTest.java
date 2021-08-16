package array.minimumSizeSubarraySum;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class MinimumSizeSubarraySumTest {

    private MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

    @Test
    public void minSubArrayLen() {
        Assert.assertEquals(2, solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }


}