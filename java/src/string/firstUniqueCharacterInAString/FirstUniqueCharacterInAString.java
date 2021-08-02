package string.firstUniqueCharacterInAString;

/* *****************************************************************************

387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 

示例：
 s = "leetcode"
返回 0
s = "loveleetcode"
返回 2

提示：你可以假定该字符串只包含小写字母。

*******************************************************************************/

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dave Wang
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(16);
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            Integer count = map.get(aChar);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
