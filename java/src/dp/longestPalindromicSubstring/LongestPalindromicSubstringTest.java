package dp.longestPalindromicSubstring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

    @Test
    public void longestPalindrome() {
        assertEquals("a", solution.longestPalindrome("a"));
        assertEquals("bab", solution.longestPalindrome("babac"));
        assertEquals("bb", solution.longestPalindrome("cbbd"));
        assertEquals("ABBA", solution.longestPalindrome("ABBA"));
    }

    @Test
    public void longestPalindromeV2() {
        assertEquals("a", solution.longestPalindromeV2("a"));
        assertEquals("bab", solution.longestPalindromeV2("babac"));
        assertEquals("bb", solution.longestPalindromeV2("cbbd"));
        assertEquals("ABBA", solution.longestPalindromeV2("ABBA"));
    }
}