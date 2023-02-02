package com.zerowzl.permutation;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

/**
 * 下一个排列 单元测试.
 *
 * @author davewang
 */
public class NextPermutationTest extends TestCase {

    public void testNextPermutation_01() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = null;
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(null, nums);
    }

    public void testNextPermutation_02() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1}, nums);
    }

    public void testNextPermutation_03() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(new int[]{2, 1, 3}, nums);
    }

    public void testNextPermutation_04() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1, 5, 1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(new int[]{5, 1, 1}, nums);
    }

    public void testNextPermutation_05() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    public void testNextPermutation_06() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1, 2, 3};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(new int[]{1, 3, 2}, nums);
    }

    public void testNextPermutation_07() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(new int[]{5, 5, 2, 3, 4, 7}, nums);
    }

    public void testNextPermutation_08() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{2, 2, 7, 5, 4, 3, 2, 2, 1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(new int[]{2, 3, 1, 2, 2, 2, 4, 5, 7}, nums);
    }

    public void testNextPermutation_09() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{2, 1, 2, 2, 2, 2, 2, 1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(new int[]{2, 2, 1, 1, 2, 2, 2, 2}, nums);
    }
}