package string.longestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author davewang
 */
public class LongestSubstringWithoutRepeatingCharactersTest {


    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcab"));
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }
}