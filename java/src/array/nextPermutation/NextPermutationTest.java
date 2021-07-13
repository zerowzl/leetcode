package array.nextPermutation;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class NextPermutationTest {

    private NextPermutation solution = new NextPermutation();

    @Test
    public void nextPermutation() {
        int[] nums = {1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    public void nextPermutation2() {
        int[] nums = {1, 2};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{2, 1}, nums);
    }

    @Test
    public void nextPermutation2_1() {
        int[] nums = {2, 1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 2}, nums);
    }

    @Test
    public void nextPermutation3_1() {
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 3, 2}, nums);
    }

    @Test
    public void nextPermutation3_2() {
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{2, 1, 3}, nums);
    }

    @Test
    public void nextPermutation3_3() {
        int[] nums = {2, 1, 3};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{2, 3, 1}, nums);
    }

    @Test
    public void nextPermutation3_4() {
        int[] nums = {2, 3, 1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{3, 1, 2}, nums);
    }

    @Test
    public void nextPermutation3_5() {
        int[] nums = {3, 1, 2};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{3, 2, 1}, nums);
    }

    @Test
    public void nextPermutation4_1() {
        int[] nums = {1, 2, 3, 4};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 2, 4, 3}, nums);
    }

    @Test
    public void nextPermutation4_2() {
        int[] nums = {1, 3, 4, 2};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 4, 2, 3}, nums);
    }

    @Test
    public void nextPermutation4_3() {
        int[] nums = {4, 3, 2, 1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    public void nextPermutation6_1() {
        int[] nums = {5, 4, 7, 5, 3, 2};
        solution.nextPermutation(nums); // [5,5,3,2,4,7]
        assertArrayEquals(new int[]{5, 5, 2, 3, 4, 7}, nums);
    }

    @Test
    public void nextPermutation9_1() {
        int[] nums = {2, 2, 7, 5, 4, 3, 2, 2, 1};
        solution.nextPermutation(nums); // [2,3,1,2,2,2,7,5,4]
        assertArrayEquals(new int[]{2, 3, 1, 2, 2, 2, 4, 5, 7}, nums);
    }
}