package string.groupAnagrams;

/* *****************************************************************************

49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
] 

说明：
所有输入均为小写字母。
不考虑答案输出的顺序。

*******************************************************************************/

/* *****************************************************************************

题解：
排序 + 哈希表

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/


import java.util.*;

/**
 * @author Dave Wang
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> list = resMap.computeIfAbsent(sortStr, k -> new ArrayList<>());
            list.add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : resMap.entrySet()) {
            List<String> value = entry.getValue();
            res.add(value);
        }

        return res;
    }

}