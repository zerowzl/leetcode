package dbsf.numberOfProvinces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class NumberOfProvincesTest {

    private NumberOfProvinces solution = new NumberOfProvinces();

    @Test
    public void findCircleNum() {
        int[][] isConnected = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        assertEquals(1, solution.findCircleNum(isConnected));
    }

    @Test
    public void findCircleNum2() {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        assertEquals(2, solution.findCircleNum(isConnected));
    }

    @Test
    public void findCircleNum3() {
        int[][] isConnected = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        assertEquals(3, solution.findCircleNum(isConnected));
    }

    @Test
    public void findCircleNum4() {
        int[][] isConnected = {
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1}
        };
        assertEquals(3, solution.findCircleNum(isConnected));
    }

    @Test
    public void findCircleNum5() {
        int[][] isConnected = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        assertEquals(1, solution.findCircleNum(isConnected));
    }
}