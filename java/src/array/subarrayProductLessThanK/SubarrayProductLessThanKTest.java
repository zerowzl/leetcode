package array.subarrayProductLessThanK;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SubarrayProductLessThanKTest {

    private SubarrayProductLessThanK solution = new SubarrayProductLessThanK();

    @Test
    public void numSubarrayProductLessThanK() {
        assertEquals(0, solution.numSubarrayProductLessThanK(new int[]{1}, 0));
        assertEquals(0, solution.numSubarrayProductLessThanK(new int[]{1000}, 0));
        assertEquals(0, solution.numSubarrayProductLessThanK(new int[]{1000, 1000, 1000}, 106));
        assertEquals(0, solution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        assertEquals(6, solution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 10));
        assertEquals(8, solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}