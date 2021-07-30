package array.mergeSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class MergeSortedArrayTest {

    private MergeSortedArray solution = new MergeSortedArray();

    @Test
    public void mergeSort() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.mergeSort(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        int[] nums2 = {1};
        solution.mergeSort(nums2, 1, new int[0], 0);
        assertArrayEquals(new int[]{1}, nums2);
    }

    @Test
    public void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        int[] nums2 = {1};
        solution.merge(nums2, 1, new int[0], 0);
        assertArrayEquals(new int[]{1}, nums2);
    }
}