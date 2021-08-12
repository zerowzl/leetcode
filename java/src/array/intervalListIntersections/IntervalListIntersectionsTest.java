package array.intervalListIntersections;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class IntervalListIntersectionsTest {

    private IntervalListIntersections solution = new IntervalListIntersections();

    @Test
    public void intervalIntersection() {
        int[][] firstList = new int[0][0];
        int[][] secondList = new int[0][0];
        assertArrayEquals(new int[0][0], solution.intervalIntersection(firstList, secondList));
    }

    @Test
    public void intervalIntersection2() {
        // 包含1
        int[][] firstList = new int[][]{new int[]{1, 2}};
        int[][] secondList = new int[][]{new int[]{0, 3}};
        assertArrayEquals(new int[][]{new int[]{1, 2}}, solution.intervalIntersection(firstList, secondList));
    }

    @Test
    public void intervalIntersection3() {
        // 包含2
        int[][] firstList = new int[][]{new int[]{0, 3}};
        int[][] secondList = new int[][]{new int[]{1, 2}};
        assertArrayEquals(new int[][]{new int[]{1, 2}}, solution.intervalIntersection(firstList, secondList));
    }

    @Test
    public void intervalIntersection4() {
        // 交叉1
        int[][] firstList = new int[][]{new int[]{0, 2}};
        int[][] secondList = new int[][]{new int[]{1, 3}};
        assertArrayEquals(new int[][]{new int[]{1, 2}}, solution.intervalIntersection(firstList, secondList));
    }

    @Test
    public void intervalIntersection5() {
        // 交叉2
        int[][] firstList = new int[][]{new int[]{1, 3}};
        int[][] secondList = new int[][]{new int[]{0, 2}};
        assertArrayEquals(new int[][]{new int[]{1, 2}}, solution.intervalIntersection(firstList, secondList));
    }

    @Test
    public void intervalIntersection6() {
        // 无
        int[][] firstList = new int[][]{new int[]{1, 3}};
        int[][] secondList = new int[][]{new int[]{4, 5}};
        assertArrayEquals(new int[0][0], solution.intervalIntersection(firstList, secondList));
    }

    @Test
    public void intervalIntersection7() {
        int[][] firstList = new int[][]{new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}};
        int[][] secondList = new int[][]{new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26}};
        assertArrayEquals(new int[][]{new int[]{1, 2}, new int[]{5, 5}, new int[]{8, 10}, new int[]{15, 23}, new int[]{24, 24}, new int[]{25, 25}},
                solution.intervalIntersection(firstList, secondList));
    }
}