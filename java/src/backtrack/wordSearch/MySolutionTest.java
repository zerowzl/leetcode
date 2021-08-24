package backtrack.wordSearch;

import org.junit.Assert;
import org.junit.Test;

public class MySolutionTest {

    // private MySolution solution = new MySolution();
    private Solution solution = new Solution();

    @Test
    public void exist() {
        char[][] board = {
                new char[]{'a', 'b', 'c'},
                new char[]{'a', 'b', 'c'},
                new char[]{'a', 'b', 'c'}
        };

        Assert.assertTrue(solution.exist(board, "abc"));
    }

    @Test
    public void exist2() {
        char[][] board = {
                new char[]{'a', 'x', 'c'},
                new char[]{'b', 'c', 'z'},
                new char[]{'t', 'v', 'c'}
        };

        Assert.assertTrue(solution.exist(board, "abc"));
    }

    @Test
    public void exist3() {
        char[][] board = {
                new char[]{'x', 'x', 'c'},
                new char[]{'x', 'a', 'b'},
                new char[]{'e', 'd', 'c'}
        };

        Assert.assertTrue(solution.exist(board, "abcde"));
    }

    @Test
    public void exist4() {
        char[][] board = {
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };

        Assert.assertFalse(solution.exist(board, "ABCB"));
    }

    @Test
    public void exist5() {
        char[][] board = {
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'E', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };

        Assert.assertTrue(solution.exist(board, "ABCESEEEFS"));
    }
}