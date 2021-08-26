package dp.arithmeticSlices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void numberOfArithmeticSlices() {
        assertEquals(0, solution.numberOfArithmeticSlices(new int[]{1}));
        assertEquals(0, solution.numberOfArithmeticSlices(new int[]{1, 2}));
        assertEquals(1, solution.numberOfArithmeticSlices(new int[]{1, 2, 3}));
        assertEquals(3, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        assertEquals(6, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
    }
}