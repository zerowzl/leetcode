package array.findFirstAndLastPositionOfElementInSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void searchRange() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{0, 1}, solution.searchRange(new int[]{1, 1, 9, 8}, 1));
    }


}