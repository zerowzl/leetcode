package binarySearch.searchInRotatedSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

    @Test
    public void binarySearch() {
        int[] a = new int[]{3, 4, 5, 6, 1, 2};
        assertEquals(0, solution.searchBS(a, 3));
        assertEquals(1, solution.searchBS(a, 4));
        assertEquals(2, solution.searchBS(a, 5));
        assertEquals(3, solution.searchBS(a, 6));
        assertEquals(4, solution.searchBS(a, 1));
        assertEquals(5, solution.searchBS(a, 2));
        assertEquals(-1, solution.searchBS(a, 0));
    }
}