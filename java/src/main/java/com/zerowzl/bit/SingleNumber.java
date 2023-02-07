package com.zerowzl.bit;

/**
 * 只出现一次的数字.
 *
 * @author davewang
 */
public class SingleNumber {

    /**
     * 利用异或的特性来解决。
     * 自己和自己异或为0，将所有的数进行异或，最终的值就是只出现一次的数字。
     */
    public int singleNumber(int[] nums) {
        int s = nums[0];
        for (int i = 1; i < nums.length; i++) {
            s ^= nums[i];
        }
        return s;
    }

}
