package slidingwindow.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 存放当前状态下的字符的数量
        Map<Character, Integer> window = new HashMap<>();
        // 窗口，左闭右开
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            // 增加统计
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 什么时候移动左窗口？有重复的字符的时候
            while (window.get(c) > 1) {
                Character d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }

            // 重新计算一次答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}