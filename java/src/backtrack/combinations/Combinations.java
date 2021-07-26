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
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = curr; i <= n; i++) {
            ans.add(i);
            backtrack(res, ans, n, k, curr + i);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations solution = new Combinations();
        List<List<Integer>> res = solution.combine(3, 3);
        System.out.println(res);
    }
}
