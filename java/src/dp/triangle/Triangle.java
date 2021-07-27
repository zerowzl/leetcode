package dp.triangle;

/* *****************************************************************************

120. 三角形最小路径和
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

示例 1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

示例 2：
输入：triangle = [[-10]]
输出：-10


提示：
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104


进阶：
你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int ans = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>(triangle.size());
        dp.add(triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curr = triangle.get(i);
            List<Integer> prev = triangle.get(i - 1);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < curr.size(); j++) {
                Integer currValue = curr.get(j);
                int updateValue;
                if (j == 0) {
                    updateValue = prev.get(j) + currValue;
                } else if (j == curr.size() - 1) {
                    updateValue = prev.get(j - 1) + currValue;
                } else {
                    updateValue = Math.min(prev.get(j), prev.get(j - 1)) + currValue;
                }
                curr.set(j, updateValue);
                min = Math.min(min, updateValue);
            }
            dp.add(min);
        }

        return dp.get(dp.size() - 1);
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + curr.get(j);
            }
        }
        return dp[0];
    }
}
