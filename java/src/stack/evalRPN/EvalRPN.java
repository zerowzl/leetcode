package stack.evalRPN;

import java.util.Stack;

/* *****************************************************************************

150. 逆波兰表达式
根据 逆波兰表示法，求表达式的值。
有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：
整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

示例 1：
输入：tokens = ["2","1","+","3","*"]
输出：9
解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

示例 2：
输入：tokens = ["4","13","5","/","+"]
输出：6
解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6

示例 3：
输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
输出：22
解释：
该算式转化为常见的中缀算术表达式为：
((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

提示：
1 <= tokens.length <= 104
tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数

*******************************************************************************/

/* *****************************************************************************

题解：
栈，遇到数字入栈，遇到符号出栈两个数进行运行然后入栈

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                switch (token) {
                    case "+": {
                        int res = left + right;
                        stack.push(res);
                        break;
                    }
                    case "-": {
                        int res = left - right;
                        stack.push(res);
                        break;
                    }
                    case "*": {
                        int res = left * right;
                        stack.push(res);
                        break;
                    }
                    default: {
                        int res = left / right;
                        stack.push(res);
                        break;
                    }
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }


}
