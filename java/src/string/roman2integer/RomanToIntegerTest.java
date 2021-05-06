package string.roman2integer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class RomanToIntegerTest {


    @Test
    public void test() {
        RomanToInteger romanToInteger = new RomanToInteger();
        Assert.assertEquals(3, romanToInteger.romanToInt("III"));
        Assert.assertEquals(4, romanToInteger.romanToInt("IV"));
        Assert.assertEquals(14, romanToInteger.romanToInt("XIV"));
        Assert.assertEquals(30, romanToInteger.romanToInt("XXX"));
    }


}
