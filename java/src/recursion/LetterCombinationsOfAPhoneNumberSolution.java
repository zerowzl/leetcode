package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17、电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author davewang
 */
public class LetterCombinationsOfAPhoneNumberSolution {

    /**
     * 回溯算法，递归所有场景
     * 官方题解：
     * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。该字符串初始为空。
     * 每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，
     * 然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。
     * 然后进行回退操作，遍历其余的字母排列。
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(res, phoneMap, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, Map<Character, String> phoneMap,
                           String digits, int index, StringBuilder resStr) {
        if (index == digits.length()) {
            res.add(resStr.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                resStr.append(letters.charAt(i));
                backtrack(res, phoneMap, digits, index + 1, resStr);
                resStr.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumberSolution solution = new LetterCombinationsOfAPhoneNumberSolution();
        System.out.println(solution.letterCombinations("23"));
    }

}
