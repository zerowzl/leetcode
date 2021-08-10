package binarySearch.findMinimumInRotatedSortedArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class FindMinimumInRotatedSortedArrayTest {

    private FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();

    @Test
    public void findMin() {
        Assert.assertEquals(1, solution.findMin(new int[]{1}));

        Assert.assertEquals(1, solution.findMin(new int[]{1, 2}));
        Assert.assertEquals(1, solution.findMin(new int[]{2, 1}));


        Assert.assertEquals(1, solution.findMin(new int[]{1, 2, 3}));
        Assert.assertEquals(1, solution.findMin(new int[]{3, 1, 2}));
        Assert.assertEquals(1, solution.findMin(new int[]{2, 3, 1}));

        Assert.assertEquals(1, solution.findMin(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(1, solution.findMin(new int[]{4, 1, 2, 3}));
        Assert.assertEquals(1, solution.findMin(new int[]{3, 4, 1, 2}));
        Assert.assertEquals(1, solution.findMin(new int[]{2, 3, 4, 1}));

        Assert.assertEquals(1, solution.findMin(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(1, solution.findMin(new int[]{5, 1, 2, 3, 4}));
        Assert.assertEquals(1, solution.findMin(new int[]{4, 5, 1, 2, 3}));
        Assert.assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(1, solution.findMin(new int[]{2, 3, 4, 5, 1}));

        Assert.assertEquals(1, solution.findMin(new int[]{1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(1, solution.findMin(new int[]{5, 6, 1, 2, 3, 4}));
        Assert.assertEquals(1, solution.findMin(new int[]{4, 5, 6, 1, 2, 3}));
        Assert.assertEquals(1, solution.findMin(new int[]{3, 4, 5, 6, 1, 2}));
        Assert.assertEquals(1, solution.findMin(new int[]{2, 3, 4, 5, 6, 1}));

        Assert.assertEquals(0, solution.findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
        Assert.assertEquals(0, solution.findMin(new int[]{7, 0, 1, 2, 4, 5, 6}));
        Assert.assertEquals(0, solution.findMin(new int[]{6, 7, 0, 1, 2, 4, 5}));
        Assert.assertEquals(0, solution.findMin(new int[]{5, 6, 7, 0, 1, 2, 4}));
        Assert.assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(0, solution.findMin(new int[]{2, 4, 5, 6, 7, 0, 1}));
        Assert.assertEquals(0, solution.findMin(new int[]{1, 2, 4, 5, 6, 7, 0}));
    }
}