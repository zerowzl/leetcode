package dp.houseRobberII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void rob() {
        assertEquals(3, solution.rob(new int[]{2, 3, 2}));
    }

    @Test
    public void rob2() {
        assertEquals(10, solution.rob(new int[]{1, 7, 9, 2}));
    }
}