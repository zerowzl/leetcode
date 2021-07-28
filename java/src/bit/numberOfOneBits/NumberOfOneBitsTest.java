package bit.numberOfOneBits;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class NumberOfOneBitsTest {

    private NumberOfOneBits solution = new NumberOfOneBits();

    @Test
    public void hammingWeight() {
        Assert.assertEquals(0, solution.hammingWeight(0));
        Assert.assertEquals(1, solution.hammingWeight(1));
        Assert.assertEquals(1, solution.hammingWeight(2));
        Assert.assertEquals(2, solution.hammingWeight(3));
        Assert.assertEquals(32, solution.hammingWeight(-1));
    }

    @Test
    public void hammingWeight_2() {
        Assert.assertEquals(0, solution.hammingWeight2(0));
        Assert.assertEquals(1, solution.hammingWeight2(1));
        Assert.assertEquals(1, solution.hammingWeight2(2));
        Assert.assertEquals(2, solution.hammingWeight2(3));
        Assert.assertEquals(32, solution.hammingWeight2(-1));
    }
}