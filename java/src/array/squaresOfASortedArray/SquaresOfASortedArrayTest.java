package array.squaresOfASortedArray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class SquaresOfASortedArrayTest {

    private SquaresOfASortedArray solution = new SquaresOfASortedArray();

    @Test
    public void sortedSquares() {
        assertArrayEquals(new int[]{1}, solution.sortedSquares(new int[]{1}));
        assertArrayEquals(new int[]{1, 4, 9}, solution.sortedSquares(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{0, 1, 4, 9}, solution.sortedSquares(new int[]{0, 1, 2, 3}));
        assertArrayEquals(new int[]{1}, solution.sortedSquares(new int[]{-1}));
        assertArrayEquals(new int[]{1, 4, 9}, solution.sortedSquares(new int[]{-3, -2, -1}));
        assertArrayEquals(new int[]{0, 1, 4, 9}, solution.sortedSquares(new int[]{-3, -2, -1, 0}));
        assertArrayEquals(new int[]{0, 1, 1, 4, 9, 9, 16}, solution.sortedSquares(new int[]{-3, -2, -1, 0, 1, 3, 4}));
    }
}