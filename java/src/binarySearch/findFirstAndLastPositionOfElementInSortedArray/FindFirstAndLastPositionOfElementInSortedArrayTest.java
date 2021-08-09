package binarySearch.findFirstAndLastPositionOfElementInSortedArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    private FindFirstAndLastPositionOfElementInSortedArray solution =
            new FindFirstAndLastPositionOfElementInSortedArray();

    @Test
    public void searchRange() {
        Assert.assertArrayEquals(new int[]{0, 0},
                solution.searchRangeBS(new int[]{1}, 1));
        Assert.assertArrayEquals(new int[]{-1, -1},
                solution.searchRangeBS(new int[]{2}, 1));
        Assert.assertArrayEquals(new int[]{-1, -1},
                solution.searchRangeBS(new int[]{2, 3, 4, 5, 6}, 1));
        Assert.assertArrayEquals(new int[]{2, 2},
                solution.searchRangeBS(new int[]{2, 3, 4, 5, 6}, 4));
        Assert.assertArrayEquals(new int[]{1, 3},
                solution.searchRangeBS(new int[]{2, 4, 4, 4, 6}, 4));
    }


}