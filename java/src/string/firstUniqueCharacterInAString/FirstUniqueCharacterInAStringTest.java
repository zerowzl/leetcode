package string.firstUniqueCharacterInAString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class FirstUniqueCharacterInAStringTest {

    private FirstUniqueCharacterInAString solution = new FirstUniqueCharacterInAString();

    @Test
    public void firstUniqChar() {
        assertEquals(0, solution.firstUniqChar("leetcode"));
        assertEquals(2, solution.firstUniqChar("loveleetcode"));
        assertEquals(-1, solution.firstUniqChar("aabbccdeed"));
    }
}