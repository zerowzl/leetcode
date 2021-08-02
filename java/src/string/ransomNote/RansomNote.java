package string.ransomNote;

/* *****************************************************************************

383. 赎金信
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
的字符构成。如果可以构成，返回 true ；否则返回 false。 
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

示例 1：
输入：ransomNote = "a", magazine = "b"
输出：false

示例 2：
输入：ransomNote = "aa", magazine = "ab"
输出：false

示例 3：
输入：ransomNote = "aa", magazine = "aab"
输出：true

提示：
 你可以假设两个字符串均只含有小写字母。

*******************************************************************************/

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dave Wang
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false;
        }
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>(16);
        char[] chars = magazine.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }

        for (char aChar : ransomNote.toCharArray()) {
            if (!map.containsKey(aChar)) {
                return false;
            } else {
                Integer count = map.get(aChar);
                if (count == 0) {
                    return false;
                } else {
                    map.put(aChar, count - 1);
                }
            }
        }

        return true;
    }
}
