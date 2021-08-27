package dp.wordBreak;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void wordBreak() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        Assert.assertTrue(solution.wordBreakByBacktrack(s, wordDict));
        Assert.assertTrue(solution.wordBreakByDP(s, wordDict));
    }

    @Test
    public void wordBreak2() {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        Assert.assertTrue(solution.wordBreakByBacktrack(s, wordDict));
        Assert.assertTrue(solution.wordBreakByDP(s, wordDict));
    }

    @Test
    public void wordBreak3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        Assert.assertFalse(solution.wordBreakByBacktrack(s, wordDict));
        Assert.assertFalse(solution.wordBreakByDP(s, wordDict));
    }

    @Test
    public void wordBreak4() {
        String s = "bb";
        List<String> wordDict = Arrays.asList("a", "b", "bb", "bbb");
        Assert.assertTrue(solution.wordBreakByBacktrack(s, wordDict));
        Assert.assertTrue(solution.wordBreakByDP(s, wordDict));
    }

    @Test
    public void wordBreak5() {
        String s = "cars";
        List<String> wordDict = Arrays.asList("car","ca","rs");
        Assert.assertTrue(solution.wordBreakByBacktrack(s, wordDict));
        Assert.assertTrue(solution.wordBreakByDP(s, wordDict));
    }

    @Test
    public void wordBreak6() {
        String s = "catsandogcat";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat","an");
        Assert.assertTrue(solution.wordBreakByBacktrack(s, wordDict));
        Assert.assertTrue(solution.wordBreakByDP(s, wordDict));
    }
}