package dp.minimumPathSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class MinimumPathSumTest {

    private MinimumPathSum solution = new MinimumPathSum();


    @Test
    public void minPathSumDP() {
        int[][] grid = new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}};
        assertEquals(7, solution.minPathSumDP(grid));
    }

    @Test
    public void minPathSumBT() {
        int[][] grid = new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}};
        assertEquals(7, solution.minPathSumBT(grid));
    }
}