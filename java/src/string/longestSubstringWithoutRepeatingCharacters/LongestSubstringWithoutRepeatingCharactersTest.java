package string.longestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class LongestSubstringWithoutRepeatingCharactersTest {


    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcab"));
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    public void lengthOfLongestSubstring_2() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(3, solution.lengthOfLongestSubstring2("abc"));
        assertEquals(0, solution.lengthOfLongestSubstring2(""));
    }
}