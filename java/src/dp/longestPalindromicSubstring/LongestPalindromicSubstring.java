package dp.longestPalindromicSubstring;

/* *****************************************************************************

5.最长回文串
给你一个字符串 s，找到 s 中最长的回文子串。 

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"
 
示例 3：
输入：s = "a"
输出："a"

示例 4：
输入：s = "ac"
输出："a"

提示：
 1 <= s.length <= 1000
 s 仅由数字和英文字母（大写和/或小写）组成 

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String ans = s.substring(0, 1);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                boolean b = isPalindrome(chars, i, j);
                if (b && (j - i + 1) > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        while (start <= end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("babac"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }

}
