package dp.wordBreak;

/* *****************************************************************************

139. 单词拆分
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 

说明：
 拆分时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。 

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
注意你可以重复使用字典中的单词。
 
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

*******************************************************************************/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dave Wang
 */
class Solution {

    /**
     * 动态规划
     */
    public boolean wordBreakByDP(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 回溯（超时）
     */
    public boolean wordBreakByBacktrack(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            if (backtrack(s, 0, wordDict, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean backtrack(String s, int start, List<String> wordDict, int startWord) {
        if (start >= s.length()) {
            return true;
        }

        for (int i = startWord; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (!equal(s, start, word)) {
                continue;
            }
            if (backtrack(s, start + word.length(), wordDict, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean equal(String s1, int start, String s2) {
        if (start + s2.length() > s1.length()) {
            return false;
        }

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        for (int i = 0; i < s2Chars.length; i++) {
            if (s2Chars[i] != s1Chars[start + i]) {
                return false;
            }
        }
        return true;
    }
}