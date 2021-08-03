package array.shortestUnsortedContinuousSubarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class ShortestUnsortedContinuousSubarrayTest {

    private ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();

    @Test
    public void findUnsortedSubarray() {
        assertEquals(0, solution.findUnsortedSubarray(new int[]{1}));
        assertEquals(0, solution.findUnsortedSubarray(
                new int[]{1, 2, 3, 4}));
        assertEquals(5, solution.findUnsortedSubarray(
                new int[]{2, 6, 4, 8, 10, 9, 15}));

        assertEquals(3, solution.findUnsortedSubarray(
                new int[]{5, 5, 3, 6, 7}));

        assertEquals(4, solution.findUnsortedSubarray(
                new int[]{1, 3, 2, 2, 2}));

        assertEquals(2, solution.findUnsortedSubarray(
                new int[]{1, 3, 2, 3, 3}));

        assertEquals(3, solution.findUnsortedSubarray(
                new int[]{1, 2, 4, 5, 3}));
    }
}