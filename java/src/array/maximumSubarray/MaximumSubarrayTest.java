package array.maximumSubarray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class MaximumSubarrayTest {

    private MaximumSubarray solution = new MaximumSubarray();

    @Test
    public void maxSubArray() {
        assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1}));
        assertEquals(4, solution.maxSubArray(new int[]{-2, 1, -3, 4}));
        assertEquals(7, solution.maxSubArray(new int[]{-2, 1, 4, -1, 2, 1, -5, 4}));
        assertEquals(-2, solution.maxSubArray(new int[]{-2}));
    }

    @Test
    public void maxSubArray_2() {
        assertEquals(6, solution.maxSubArrayV2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(6, solution.maxSubArrayV2(new int[]{-2, 1, -3, 4, -1, 2, 1}));
        assertEquals(4, solution.maxSubArrayV2(new int[]{-2, 1, -3, 4}));
        assertEquals(7, solution.maxSubArrayV2(new int[]{-2, 1, 4, -1, 2, 1, -5, 4}));
        assertEquals(-2, solution.maxSubArrayV2(new int[]{-2}));
    }

    @Test
    public void maxSubArray_3() {
        assertEquals(6, solution.maxSubArrayV3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(6, solution.maxSubArrayV3(new int[]{-2, 1, -3, 4, -1, 2, 1}));
        assertEquals(4, solution.maxSubArrayV3(new int[]{-2, 1, -3, 4}));
        assertEquals(7, solution.maxSubArrayV3(new int[]{-2, 1, 4, -1, 2, 1, -5, 4}));
        assertEquals(-2, solution.maxSubArrayV3(new int[]{-2}));
    }
}