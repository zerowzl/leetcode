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

    /**
     * 暴力
     */
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

    /**
     * DP
     */
    public String longestPalindromeV2(String s) {
        if (s.length() == 1) {
            return s;
        }

        int begin = 0;
        int length = 1;
        boolean[][] value = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            value[i][i] = true;
        }

        // 步长递增 ADDA
        // 1 --> [0,1] [1,2] [2,3]
        // 2 --> [0,2] [1,3]
        // 3 --> [0,3]

        for (int L = 2; L <= chars.length; L++) {
            for (int i = 0; i < chars.length; i++) {
                // i 递增, j 随着 L 的增加实现步长的增加
                int j = L + i - 1;

                if (j >= chars.length) {
                    break;
                }

                if (chars[i] != chars[j]) {
                    value[i][j] = false;
                } else {
                    // 中间没有或者有一个元素, 那就是回文
                    if (j - i < 3) {
                        value[i][j] = true;
                    } else {
                        // ABBA 时, 看 BB 是不是回文
                        value[i][j] = value[i + 1][j - 1];
                    }
                }

                // 重置
                if (value[i][j] && j - i + 1 > length) {
                    begin = i;
                    length = j - i + 1;
                }
            }
        }

        return s.substring(begin, begin + length);
    }

}
