package array.setMatrixZeroes;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class SetMatrixZeroesTest {

    private SetMatrixZeroes solution = new SetMatrixZeroes();

    @Test
    public void setZeroes() {
        int[][] matrix = {new int[]{0, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 0}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0},
                new int[]{0, 0, 0}}, matrix);
    }
}