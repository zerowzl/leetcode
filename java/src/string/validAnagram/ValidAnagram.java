package string.validAnagram;

/* *****************************************************************************

242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 

示例 1:
输入: s = "anagram", t = "nagaram"
输出: true

示例 2:
输入: s = "rat", t = "car"
输出: false 

说明:
你可以假设字符串只包含小写字母。 

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 

*******************************************************************************/

/* *****************************************************************************

题解：
1、先排序，再比较
2、统计每个字母出现的次数，放入 map

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/


import java.util.HashMap;
import java.util.Map;

class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // s
        Map<Character, Integer> sCountMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (sCountMap.containsKey(aChar)) {
                sCountMap.put(aChar, sCountMap.get(aChar) + 1);
            } else {
                sCountMap.put(aChar, 1);
            }
        }

        // t
        Map<Character, Integer> tCountMap = new HashMap<>();
        char[] tChars = t.toCharArray();
        for (char aChar : tChars) {
            if (tCountMap.containsKey(aChar)) {
                tCountMap.put(aChar, tCountMap.get(aChar) + 1);
            } else {
                tCountMap.put(aChar, 1);
            }
        }

        return sCountMap.equals(tCountMap);
    }

}