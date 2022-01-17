package binarySearch.binarySearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class BinarySearchTest {

    private BinarySearch solution = new BinarySearch();

    @Test
    public void searchRange() {
        Assert.assertEquals(-1, solution.search(null, 1));
        Assert.assertEquals(-1, solution.search(new int[]{}, 1));
        Assert.assertEquals(-1, solution.search(new int[]{2}, 1));
        Assert.assertEquals(0, solution.search(new int[]{1, 2, 3, 4, 5, 6}, 1));
    }


}