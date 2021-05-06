package array.findFirstAndLastPositionOfElementInSortedArray;

import org.junit.Test;
import org.junit.Assert;

/**
 * @author Dave Wang
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void searchRange() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        Assert.assertArrayEquals(new int[]{0,0}, solution.searchRange(new int[]{1}, 1));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{2}, 1));
    }



}