package array.medianOfTwoSortedArrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author davewang
 */
public class MedianOfTwoSortedArraysTest {

    @Test
    public void findMedianSortedArrays() {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        assertEquals(1.0, solution.findMedianSortedArrays(new int[0], new int[]{1}), 0);
        assertEquals(1.0, solution.findMedianSortedArrays(new int[]{1}, new int[]{1}), 0);
        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0);
        assertEquals(4.0, solution.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 6}), 0);
    }
}