package bit.powerOfTwo;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class PowerOfTwoTest {

    private PowerOfTwo solution = new PowerOfTwo();

    @Test
    public void isPowerOfTwo() {
        assertFalse(solution.isPowerOfTwo(0));
        assertTrue(solution.isPowerOfTwo(1));
        assertTrue(solution.isPowerOfTwo(2));
        assertFalse(solution.isPowerOfTwo(-4));
        assertTrue(solution.isPowerOfTwo(4));
        assertFalse(solution.isPowerOfTwo(Integer.MIN_VALUE));
        assertFalse(solution.isPowerOfTwo(Integer.MAX_VALUE));
    }

    @Test
    public void isPowerOfTwo2() {
        assertFalse(solution.isPowerOfTwo2(0));
        assertTrue(solution.isPowerOfTwo2(1));
        assertTrue(solution.isPowerOfTwo2(2));
        assertFalse(solution.isPowerOfTwo2(-4));
        assertTrue(solution.isPowerOfTwo2(4));
        assertFalse(solution.isPowerOfTwo2(Integer.MIN_VALUE));
        assertFalse(solution.isPowerOfTwo2(Integer.MAX_VALUE));
    }

    @Test
    public void isPowerOfTwo3() {
        assertFalse(solution.isPowerOfTwo3(0));
        assertTrue(solution.isPowerOfTwo3(1));
        assertTrue(solution.isPowerOfTwo3(2));
        assertFalse(solution.isPowerOfTwo3(-4));
        assertTrue(solution.isPowerOfTwo3(4));
        assertFalse(solution.isPowerOfTwo3(Integer.MIN_VALUE));
        assertFalse(solution.isPowerOfTwo3(Integer.MAX_VALUE));
    }
}