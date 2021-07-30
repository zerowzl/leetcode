package array.reshapeTheMatrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class ReshapeTheMatrixTest {

    private ReshapeTheMatrix solution = new ReshapeTheMatrix();

    @Test
    public void matrixReshape() {
        assertArrayEquals(new int[][]{new int[]{1, 2, 3, 4}}, solution.matrixReshape(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 1, 4));
        assertArrayEquals(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, solution.matrixReshape(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 2, 4));
    }
}