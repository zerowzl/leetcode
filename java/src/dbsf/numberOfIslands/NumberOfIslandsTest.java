package dbsf.numberOfIslands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class NumberOfIslandsTest {

    private NumberOfIslands solution = new NumberOfIslands();

    @Test
    public void numIslands() {
        char[][] grid = {};
        assertEquals(0, solution.numIslandsDFS(grid));
    }

    @Test
    public void numIslands1() {
        char[][] grid = {
                {'1', '1'},
                {'1', '1'}
        };
        assertEquals(1, solution.numIslandsDFS(grid));
    }

    @Test
    public void numIslands2() {
        char[][] grid = {
                {'1', '0', '1'},
                {'1', '0', '1'}
        };
        assertEquals(2, solution.numIslandsDFS(grid));
    }

    @Test
    public void numIslands3() {
        char[][] grid = {
                {'1', '1', '0', '1'},
                {'1', '1', '0', '0'},
                {'1', '1', '0', '1'},
                {'1', '1', '0', '0'}
        };
        assertEquals(3, solution.numIslandsDFS(grid));
    }
}