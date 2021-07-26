package dp.zeroOneMatrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class ZeroOneMatrixTest {

    private ZeroOneMatrix solution = new ZeroOneMatrix();

    @Test
    public void updateMatrix() {
        int[][] ans = solution.updateMatrix(new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}});
        int[][] exp = {{2, 1, 2}, {1, 0, 1}, {2, 1, 2}};
        assertArrayEquals(exp, ans);
    }

    @Test
    public void updateMatrix_2() {
        int[][] ans = solution.updateMatrix(new int[][]{new int[]{0, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}});
        int[][] exp = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}};
        assertArrayEquals(exp, ans);
    }

    @Test
    public void updateMatrix_3() {
        int[][] ans = solution.updateMatrix(new int[][]{new int[]{0, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 0}});
        int[][] exp = {{0, 1, 2}, {1, 2, 1}, {2, 1, 0}};
        assertArrayEquals(exp, ans);
    }
}