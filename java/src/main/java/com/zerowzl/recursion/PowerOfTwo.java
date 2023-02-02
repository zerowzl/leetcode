package com.zerowzl.recursion;

/**
 * 2 的次幂.
 *
 * @author davewang
 */
public class PowerOfTwo {

    /**
     * 递归解法，栈溢出。
     */
    public boolean isPowerOfTwo_01(int n) {
        if (n == 1 || n == 2) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    /**
     * int 中最大的 2的幂 的数.
     */
    static final int BIT = 1 << 30;

    public boolean isPowerOfTwo(int n) {
        // 最大公约数
        return n > 0 && BIT % n == 0;
    }

}
