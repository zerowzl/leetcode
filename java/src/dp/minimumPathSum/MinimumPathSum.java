package dp.minimumPathSum;

/* *****************************************************************************

64. 最小路径和
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
说明：每次只能向下或者向右移动一步。

示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。

示例 2：
输入：grid = [[1,2,3],[4,5,6]]
输出：12

提示：
 m == grid.length
 n == grid[i].length 
 1 <= m, n <= 200 
 0 <= grid[i][j] <= 100 

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class MinimumPathSum {

    /**
     * 动态规划
     */
    public int minPathSumDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 状态转移表
        int[][] dp = new int[m][n];
        int temp = 0;
        for (int i = 0; i < m; i++) {
            temp = temp + grid[i][0];
            dp[i][0] = temp;
        }

        temp = 0;
        for (int i = 0; i < n; i++) {
            temp = temp + grid[0][i];
            dp[0][i] = temp;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 当前节点的值为左节点和上节点中小的那个加上本身自己的值
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 回溯(超出内存限制)
     */
    public int minPathSumBT(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> ans = new ArrayList<>();
        backtrack(grid, m, n, 0, 0, grid[0][0], ans);

        // System.out.println(ans);

        int res = ans.get(0);
        for (Integer i : ans) {
            res = Math.min(i, res);
        }
        return res;
    }


    private void backtrack(int[][] grid, int m, int n, int i, int j, int curr, List<Integer> ans) {
        // System.out.println("i: " + i);
        // System.out.println("j: " + j);
        // System.out.println("curr: " + curr);
        if (i == m - 1 && j == n - 1) {
            ans.add(curr);
            return;
        }

        // 行到头了, 只能向下了
        if (i == m - 1) {
            backtrack(grid, m, n, i, j + 1, curr + grid[i][j + 1], ans);
        } else if (j == n - 1) {
            // 列到头了, 只能向右了
            backtrack(grid, m, n, i + 1, j, curr + grid[i + 1][j], ans);
        } else {
            // 都可以选
            backtrack(grid, m, n, i, j + 1, curr + grid[i][j + 1], ans);
            backtrack(grid, m, n, i + 1, j, curr + grid[i + 1][j], ans);
        }
    }
}
