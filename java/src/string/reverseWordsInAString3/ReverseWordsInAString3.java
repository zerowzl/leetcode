package string.reverseWordsInAString3;

/* *****************************************************************************

557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

提示：
在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class ReverseWordsInAString3 {

    public String reverseWords(String s) {
        String[] wordArr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String word : wordArr) {
            ans.append(reverse(word)).append(" ");
        }
        return ans.deleteCharAt(ans.length() - 1).toString();
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        ReverseWordsInAString3 solution = new ReverseWordsInAString3();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

}
