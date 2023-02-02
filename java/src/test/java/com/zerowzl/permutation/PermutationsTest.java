package com.zerowzl.permutation;

import junit.framework.TestCase;

import java.util.List;

/**
 * 全排列 单元测试.
 *
 * @author davewang
 */
public class PermutationsTest extends TestCase {

    public void testPermute_01() {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1};
        List<List<Integer>> ans = permutations.permute(nums);
        System.out.println(ans);
    }

    public void testPermute_02() {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1, 2};
        List<List<Integer>> ans = permutations.permute(nums);
        System.out.println(ans);
    }

    public void testPermute_03() {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = permutations.permute(nums);
        System.out.println(ans);
    }

    public void testPermute_04() {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1, 2, 4, 5};
        List<List<Integer>> ans = permutations.permute(nums);
        System.out.println(ans);
    }
}