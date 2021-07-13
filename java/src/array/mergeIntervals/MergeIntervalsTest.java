package array.mergeIntervals;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class MergeIntervalsTest {

    private MergeIntervals solution = new MergeIntervals();

    @Test
    public void merge() {
        int[][] intervals = new int[2][2];
        intervals[0] = new int[]{2, 4};
        intervals[1] = new int[]{1, 3};
        int[][] res = solution.merge(intervals);
        assertArrayEquals(new int[][]{new int[]{1, 4}}, res);
    }

    @Test
    public void merge_1() {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{2, 4};
        intervals[1] = new int[]{1, 3};
        intervals[2] = new int[]{5, 7};
        intervals[3] = new int[]{6, 8};
        int[][] res = solution.merge(intervals);
        assertArrayEquals(new int[][]{new int[]{1, 4}, new int[]{5, 8}}, res);
    }

    @Test
    public void merge_2() {
        int[][] intervals = new int[5][2];
        intervals[0] = new int[]{2, 4};
        intervals[1] = new int[]{1, 3};
        intervals[2] = new int[]{1, 5};
        intervals[3] = new int[]{5, 7};
        intervals[4] = new int[]{6, 8};
        int[][] res = solution.merge(intervals);
        assertArrayEquals(new int[][]{new int[]{1, 8}}, res);
    }
    @Test
    public void merge_3() {
        int[][] intervals = new int[5][2];
        intervals[0] = new int[]{2, 4};
        intervals[1] = new int[]{1, 5};
        intervals[2] = new int[]{1, 5};
        intervals[3] = new int[]{5, 7};
        intervals[4] = new int[]{6, 8};
        int[][] res = solution.merge(intervals);
        assertArrayEquals(new int[][]{new int[]{1, 8}}, res);
    }
}