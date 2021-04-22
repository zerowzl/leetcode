package array.twoSum;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class TwoSumTest {

    @Test
    public void test() {
        TwoSum solution = new TwoSum();
        int[] res = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertArrayEquals(new int[]{1, 0}, res);
    }
}
