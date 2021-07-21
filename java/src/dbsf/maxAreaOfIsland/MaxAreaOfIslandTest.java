package dbsf.maxAreaOfIsland;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class MaxAreaOfIslandTest {

    private MaxAreaOfIsland solution = new MaxAreaOfIsland();

    @Test
    public void maxAreaOfIslandDFS() {
        int[][] grid = {new int[]{0, 0, 0}};
        assertEquals(0, solution.maxAreaOfIslandDFS(grid));
    }

    @Test
    public void maxAreaOfIslandDFS_2() {
        int[][] grid = {
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}};
        assertEquals(1, solution.maxAreaOfIslandDFS(grid));
    }

    @Test
    public void maxAreaOfIslandDFS_3() {
        int[][] grid = {
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 0},
                new int[]{0, 0, 0, 1, 0},
                new int[]{0, 1, 1, 1, 0},
                new int[]{0, 0, 0, 0, 0}};
        assertEquals(7, solution.maxAreaOfIslandDFS(grid));
    }

    @Test
    public void maxAreaOfIslandBFS() {
        int[][] grid = {new int[]{0, 0, 0}};
        assertEquals(0, solution.maxAreaOfIslandBFS(grid));
    }

    @Test
    public void maxAreaOfIslandBFS_2() {
        int[][] grid = {
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}};
        assertEquals(1, solution.maxAreaOfIslandBFS(grid));
    }

    @Test
    public void maxAreaOfIslandBFS_3() {
        int[][] grid = {
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 0},
                new int[]{0, 0, 0, 1, 0},
                new int[]{0, 1, 1, 1, 0},
                new int[]{0, 0, 0, 0, 0}};
        assertEquals(7, solution.maxAreaOfIslandBFS(grid));
    }
}