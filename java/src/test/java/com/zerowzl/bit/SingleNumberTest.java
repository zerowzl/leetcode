package com.zerowzl.bit;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * 只出现一次的数字 单元测试.
 *
 * @author davewang
 */
public class SingleNumberTest extends TestCase {

    public void testSingleNumber() {
        SingleNumber solution = new SingleNumber();
        Assert.assertEquals(0, solution.singleNumber(new int[]{0}));
        Assert.assertEquals(1, solution.singleNumber(new int[]{2, 2, 1}));
    }
}