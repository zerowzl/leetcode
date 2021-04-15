package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配。
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author Dave Wang
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            // 左括号，入栈
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
                continue;
            }
            // 右括号，出栈
            if (aChar == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '(') {
                    return false;
                }
            }
            if (aChar == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '{') {
                    return false;
                }
            }
            if (aChar == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidV2(String s) {
        Map<Character, Character> map = new HashMap<>(8);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character peek = stack.peek();
                if (!map.get(aChar).equals(peek)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }

}
