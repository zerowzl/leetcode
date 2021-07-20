package string.permutationInString;

/* *****************************************************************************

567. 字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
换句话说，第一个字符串的排列之一是第二个字符串的 子串 。

示例 1：
输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").

示例 2：
输入: s1= "ab" s2 = "eidboaoo"
输出: False

提示：
 1 <= s1.length, s2.length <= 104
 s1 和 s2 仅包含小写字母 

*******************************************************************************/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dave Wang
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = i;
            Map<Character, Integer> map = buildMap(s1);
            while (j < chars.length && map.containsKey(chars[j])) {
                Integer count = map.get(chars[j]);
                if (count == 1) {
                    map.remove(chars[j]);
                    if (map.isEmpty()) {
                        return true;
                    }
                } else {
                    map.put(chars[j], count - 1);
                }
                j++;
            }
        }

        return false;
    }

    private Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> res = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (res.containsKey(aChar)) {
                res.put(aChar, res.get(aChar) + 1);
            } else {
                res.put(aChar, 1);
            }
        }
        return res;
    }


    /**
     * 基于字符串每个字符在不同排列下的数量都一样
     */
    public boolean checkInclusion2(String s1, String s2) {
        int m = s2.length();
        int n = s1.length();
        if (n > m) {
            return false;
        }

        // a1 存的是 s1 每个字符的数量
        int[] a1 = new int[26];
        // a2 存的是 s1 长度范围内的每个字符的数量
        int[] a2 = new int[26];
        for (int i = 0; i < n; i++) {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a1, a2)) {
            return true;
        }

        // 向右移动 s2 的范围 (m-n 次)
        for (int i = 0; i < m - n; i++) {
            // 移除左边界
            a2[s2.charAt(i) - 'a']--;
            // 增加右边界
            a2[s2.charAt(n + i) - 'a']++;
            if (Arrays.equals(a1, a2)) {
                return true;
            }
        }
        return false;
    }
}
