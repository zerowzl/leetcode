package dp.trappingRainWater;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class TrappingRainWaterTest {

    TrappingRainWater solution = new TrappingRainWater();

    @Test
    public void trapForce() {
        assertEquals(6, solution.trapForce(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, solution.trapForce(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    public void trapDP() {
        assertEquals(6, solution.trapDP(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, solution.trapDP(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    public void trapDoublePrint() {
        assertEquals(6, solution.trapDoublePrint(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, solution.trapDoublePrint(new int[]{4, 2, 0, 3, 2, 5}));
    }
}