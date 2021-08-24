package backtrack.generateParentheses;

/* *****************************************************************************

22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]
 
提示：
1 <= n <= 8

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // backtrack(res, new StringBuilder(), 0, 0, n);
        backtrackV2(res, new StringBuilder(), 0, 0, n);
        return res;
    }

        /*
            以 n = 2 为例，生成的过程
                    (
                (       )
            )               (
        )                       )
     */

    /**
     * 使用回溯算法，生成所有的解。
     * 选择当前使用那个元素之后，下一个元素可选择的有两种情况 '(' 和 ')'，我们通过控制下一个元素的选择来生成符合条件的解。
     *
     * @param res   结果
     * @param ans   每次的解
     * @param open  '(' 的数量
     * @param close ')' 的数量
     * @param n     '()' 对数
     */
    private void backtrack(List<String> res, StringBuilder ans, int open, int close, int n) {
        // 如果 ans 的长度等于 n * 2，说明 '()' 已经生成完成
        if (ans.length() == n * 2) {
            res.add(ans.toString());
            return;
        }

        // ( 的数量不能超过 n 个
        if (open < n) {
            // 先放置一个 (
            ans.append("(");
            // 将 open + 1，递归调用
            backtrack(res, ans, open + 1, close, n);
            // 回来之后还原 ans
            ans.deleteCharAt(ans.length() - 1);
        }

        // ) 只能出现在 ( 后面
        if (open > close) {
            // 放置一个 )
            ans.append(")");
            // 将 close + 1，递归调用
            backtrack(res, ans, open, close + 1, n);
            // 回来之后还原 )
            ans.deleteCharAt(ans.length() - 1);
        }
    }


    private void backtrackV2(List<String> res, StringBuilder ans, int open, int close, int n) {
        if (close == n) {
            res.add(ans.toString());
            return;
        }

        if (open < n) {
            ans.append("(");
            backtrackV2(res, ans, open + 1, close, n);
            ans.deleteCharAt(ans.length() - 1);
        }

        if (open > close) {
            ans.append(")");
            backtrackV2(res, ans, open, close + 1, n);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
}
