package binarySearch.searchA2dMatrix;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class SearchA2dMatrixTest {

    private SearchA2dMatrix solution = new SearchA2dMatrix();

    @Test
    public void searchMatrix() {
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        };
        assertFalse(solution.searchMatrix(matrix, 0));
        assertTrue(solution.searchMatrix(matrix, 1));
        assertTrue(solution.searchMatrix(matrix, 3));
        assertFalse(solution.searchMatrix(matrix, 8));
        assertTrue(solution.searchMatrix(matrix, 10));
        assertTrue(solution.searchMatrix(matrix, 16));
        assertTrue(solution.searchMatrix(matrix, 23));
        assertTrue(solution.searchMatrix(matrix, 60));
        assertFalse(solution.searchMatrix(matrix, 61));
    }
}