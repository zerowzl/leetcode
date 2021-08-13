package string.findAllAnagramsInAString;

/* *****************************************************************************

438. 找到字符串中所有字母异位词
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
异位词 指字母相同，但排列不同的字符串。

示例 1:
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 
示例 2:
输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

提示:
 1 <= s.length, p.length <= 3 * 104
 s 和 p 仅包含小写字母

*******************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class FindAllAnagramsInAString {


    // bad
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }

        // 排序
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = p.length();
        while (j <= s.length()) {
            // 比较
            if (isEctopic(s.substring(i, j), pChars)) {
                ans.add(i);
            }
            i++;
            j++;
        }

        return ans;
    }

    private boolean isEctopic(String s1, char[] s2) {
        char[] a = s1.toCharArray();
        Arrays.sort(a);
        return Arrays.equals(a, s2);
    }

    /**
     * 滑动窗口 + 数组
     *
     * 1. 因为只有小写字母，可以通过长度26的数组来存每个字母出现的次数。
     * 2. 然后从 s 中取出长度为 （p 的长度的）的字符串来统计每个字母出现的次数来进行比较。
     * 3. 循环 p.length - s.length 次, 每次去除头, 加上下一个元素进行比较。
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int n = s.length(), m = p.length();
        if (n < m) {
            return Collections.emptyList();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            // s.charAt(i) - 'a' 得出从 a 开始的下标
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // 循环 n - m
        for (int i = m; i < n; i++) {
            sCount[s.charAt(i - m) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - m + 1);
            }
        }

        return ans;
    }

}
