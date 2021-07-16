package dp.uniquePaths;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class UniquePathsTest {

    private UniquePaths solution = new UniquePaths();

    @Test
    public void uniquePaths() {
        assertEquals(3, solution.uniquePaths(3, 2));
        assertEquals(3, solution.uniquePaths(2, 3));
        assertEquals(28, solution.uniquePaths(3, 7));
        assertEquals(28, solution.uniquePaths(7, 3));
        assertEquals(6, solution.uniquePaths(3, 3));
    }
}