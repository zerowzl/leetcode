package com.zerowzl.recursion;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * .
 *
 * @author davewang
 */
public class PowerOfTwoTest extends TestCase {

    public void testIsPowerOfTwo() {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        Assert.assertTrue(powerOfTwo.isPowerOfTwo(1));
        Assert.assertTrue(powerOfTwo.isPowerOfTwo(2));
        Assert.assertFalse(powerOfTwo.isPowerOfTwo(3));
        Assert.assertTrue(powerOfTwo.isPowerOfTwo(4));
        Assert.assertFalse(powerOfTwo.isPowerOfTwo(5));
        Assert.assertFalse(powerOfTwo.isPowerOfTwo(6));
        Assert.assertFalse(powerOfTwo.isPowerOfTwo(7));
        Assert.assertTrue(powerOfTwo.isPowerOfTwo(8));
    }
}