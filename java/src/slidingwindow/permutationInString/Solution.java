package slidingwindow.permutationInString;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 存放需要的和当前状态下的【字符和数量】
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character key = s1.charAt(i);
            needs.put(key, needs.getOrDefault(key, 0) + 1);
        }

        // 窗口，左闭右开
        int left = 0;
        int right = 0;
        // 标识当前窗口是否满足了要求，用来缩小窗口用
        int valid = 0;

        while (right < s2.length()) {
            Character c = s2.charAt(right);
            right++;
            // 是需要的字符
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 和需要的字符数量也是一样的
                if (needs.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 什么时候移动左窗口？因为是求排列，因此是窗口大小大于等于字符串长度时
            while (right - left >= s1.length()) {
                // 窗口内的字符串满足条件了
                if (valid == needs.size()) {
                    return true;
                }

                // 要移出窗口的字符
                Character d = s2.charAt(left);
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
        return false;
    }
}