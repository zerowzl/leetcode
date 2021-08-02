package array.validSudoku;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class ValidSudokuTest {

    private ValidSudoku solution = new ValidSudoku();

    @Test
    public void isValidSudoku() {
        char[][] board = new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        assertTrue(solution.isValidSudoku(board));
    }

    @Test
    public void isValidSudoku_2() {
        char[][] board = new char[][]{
                new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        assertTrue(solution.isValidSudoku(board));
    }

    @Test
    public void isValidSudoku_3() {
        char[][] board = new char[][]{
                new char[]{'1', '.', '.', '4', '5', '6', '7', '8', '9'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        assertTrue(solution.isValidSudoku(board));
    }

    @Test
    public void isValidSudoku_4() {
        char[][] board = new char[][]{
                new char[]{'1', '.', '.', '4', '5', '6', '7', '8', '9'},
                new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '2', '.', '.', '.', '.', '.', '.'},
                new char[]{'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        assertFalse(solution.isValidSudoku(board));
    }

    @Test
    public void isValidSudoku_5() {
        char[][] board = new char[][]{
                new char[]{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                new char[]{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', ',', '.', '.', '3', '.', '.', '1'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                new char[]{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                new char[]{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                new char[]{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        assertFalse(solution.isValidSudoku(board));
    }
}
