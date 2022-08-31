package slidingwindow.minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
class Solution {
    /**
     * 滑动窗口
     */
    public String minWindow(String s, String t) {
        // 存放需要的和当前状态下的【字符和数量】
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            needs.put(key, needs.getOrDefault(key, 0) + 1);
        }

        // 窗口，左闭右开
        int left = 0;
        int right = 0;

        // 答案的开始索引和长度
        int start = 0;
        int length = Integer.MAX_VALUE;

        // 标识当前窗口是否满足了要求，用来缩小窗口用
        int valid = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            // 是需要的字符
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 和需要的字符数量也是一样的
                if (needs.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 窗口内的字符串满足条件了
            while (valid == needs.size()) {
                // 更新答案
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }

                // 要移出窗口的字符
                Character d = s.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    // 和需要的字符数量也是一样的
                    if (needs.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}