package dp.houseRobber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class HouseRobberTest {

    private HouseRobber solution = new HouseRobber();

    @Test
    public void robBT() {
        assertEquals(4, solution.robBT(new int[]{1, 2, 3, 1}));
        assertEquals(12, solution.robBT(new int[]{2, 7, 9, 3, 1}));
        assertEquals(7, solution.robBT(new int[]{2, 0, 1, 5, 1}));
    }

    @Test
    public void robDP() {
        assertEquals(4, solution.robDP(new int[]{1, 2, 3, 1}));
        assertEquals(12, solution.robDP(new int[]{2, 7, 9, 3, 1}));
        assertEquals(7, solution.robDP(new int[]{2, 0, 1, 5, 1}));
        assertEquals(103, solution.robDP(new int[]{1, 3, 1, 3, 100}));
    }
}