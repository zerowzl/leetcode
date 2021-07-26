package dbsf.rottingOranges;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class RottingOrangesTest {

    private RottingOranges solution = new RottingOranges();

    @Test
    public void orangesRotting() {
        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(4, solution.orangesRotting(grid));

        int[][] grid2 = {{2, 1, 1}, {0, 0, 1}, {1, 0, 1}};
        assertEquals(-1, solution.orangesRotting(grid2));

        int[][] grid3 = {{0, 2}};
        assertEquals(0, solution.orangesRotting(grid3));
    }
}