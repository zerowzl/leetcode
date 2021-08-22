package dbsf.surroundedRegions;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void solve() {
        char[][] board = new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    @Test
    public void solve1() {
        char[][] board = new char[][]{new char[]{'X'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    @Test
    public void solve2() {
        char[][] board = new char[][]{
                new char[]{'X','O','X','O','X','O'},
                new char[]{'O','X','O','X','O','X'},
                new char[]{'X','O','X','O','X','O'},
                new char[]{'O','X','O','X','O','X'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}