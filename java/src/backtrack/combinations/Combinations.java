package backtrack.combinations;

/* *****************************************************************************

77. 组合
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
你可以按 任何顺序 返回答案。

示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
] 

示例 2：
输入：n = 1, k = 1
输出：[[1]] 

提示：
 1 <= n <= 20
 1 <= k <= n 

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> ans, int n, int k, int curr) {
        // 递归终止条件是：path 的长度等于 k
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }

        // 遍历可能的搜索起点
        // for (int i = curr; i <= n; i++) {
        for (int i = curr; i <= n - (k - ans.size()) + 1; i++) {
            // 向路径变量里添加一个数
            ans.add(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            backtrack(res, ans, n, k, i + 1);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            ans.remove(ans.size() - 1);
        }
    }

}
