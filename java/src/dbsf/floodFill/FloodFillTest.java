package dbsf.floodFill;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class FloodFillTest {

    private FloodFill solution = new FloodFill();

    @Test
    public void floodFill() {
        int[][] image = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}};
        int[][] res = solution.floodFill(image, 1, 1, 2);
        assertArrayEquals(new int[][]{new int[]{2, 2, 2}, new int[]{2, 2, 0}, new int[]{2, 0, 1}}, res);
    }

    @Test
    public void floodFill_1() {
        int[][] image = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}};
        int[][] res = solution.floodFill(image, 1, 1, 2);
        assertArrayEquals(new int[][]{new int[]{2, 2, 2}, new int[]{2, 2, 0}}, res);
    }

    @Test
    public void floodFill_2() {
        int[][] image = new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 0}};
        int[][] res = solution.floodFill(image, 1, 1, 2);
        assertArrayEquals(new int[][]{new int[]{0, 0, 0}, new int[]{0, 2, 0}}, res);
    }
}