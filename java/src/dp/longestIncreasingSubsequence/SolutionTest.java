package dp.longestIncreasingSubsequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void lengthOfLIS() {
        assertEquals(1, solution.lengthOfLIS(new int[]{1}));
        assertEquals(2, solution.lengthOfLIS(new int[]{1, 2}));
        assertEquals(3, solution.lengthOfLIS(new int[]{1, 2, 3}));
        assertEquals(1, solution.lengthOfLIS(new int[]{3, 2, 1}));

        assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(1, solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}