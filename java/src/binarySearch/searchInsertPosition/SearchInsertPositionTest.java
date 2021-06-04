package binarySearch.searchInsertPosition;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class SearchInsertPositionTest {

    private SearchInsertPosition solution = new SearchInsertPosition();

    private int[] nums = new int[]{1, 3, 5, 6};

    @Test
    public void searchInsert() {
        assertEquals(2, solution.searchInsert(nums, 5));
        assertEquals(1, solution.searchInsert(nums, 2));
        assertEquals(0, solution.searchInsert(nums, 0));
        assertEquals(4, solution.searchInsert(nums, 7));
    }
}