package string.longestSubstringWithoutRepeatingCharacters;

/* *****************************************************************************

3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

示例 4:
输入: s = ""
输出: 0

提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成

*******************************************************************************/

/* *****************************************************************************

题解1：滑动窗口
使用双指针，start 表示开始位，end 表示结束位；首先第一次的 start 位就是元素开始位置，end 依次增加，直到出现重复元素；
然后下一次直接从 start + 1 位开始，end 从上次的end 位开始（因为前面已经证明了这部分是不会出现重复元素的）。
重复元素的判断可以使用 set，start 增加 set 删除元素，end 增加判断是否重复并增加元素。

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

import java.util.HashSet;
import java.util.Set;

/**
 * @author davewang
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int end = -1, length = s.length(), ans = 0;

        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (end + 1 < length && !set.contains(s.charAt(end + 1))) {
                set.add(s.charAt(end + 1));
                end++;
            }
            ans = Math.max(ans, set.size());
        }

        return ans;
    }


}
