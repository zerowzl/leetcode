package dbsf.maxAreaOfIsland;

/* *****************************************************************************

695. 岛屿的最大面积
给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被
0（代表水）包围着。 

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)

示例 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。

示例 2:
 [[0,0,0,0,0,0,0,0]]

对于上面这个给定的矩阵, 返回 0。

注意: 给定的矩阵grid 的长度和宽度都不超过 50。

*******************************************************************************/

/* *****************************************************************************

题解：
深度优先算法

复杂度分析：
时间复杂度：O(m * n)
空间复杂度：O(m * n)

*******************************************************************************/

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dave Wang
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIslandDFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(grid, m, n, i, j));
            }
        }

        return ans;
    }

    /**
     * dfs
     *
     * @param grid 地图
     * @param m    行
     * @param n    列
     * @param i    当前行
     * @param j    当前列
     * @return 连续1的数量
     */
    private int dfs(int[][] grid, int m, int n, int i, int j) {
        // 到达边界或者不等于1
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }

        // 扫描过的点设置为0, 防止重复扫描
        grid[i][j] = 0;

        // 向上下左右四个方向递归扫描
        int ans = 1;
        ans += dfs(grid, m, n, i - 1, j);
        ans += dfs(grid, m, n, i + 1, j);
        ans += dfs(grid, m, n, i, j - 1);
        ans += dfs(grid, m, n, i, j + 1);
        return ans;
    }


    public int maxAreaOfIslandBFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, bfs(grid, m, n, i, j));
            }
        }

        return ans;
    }

    private int bfs(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curI = cur[0];
            int curJ = cur[1];
            grid[curI][curJ] = 0;
            ans++;
            if (curI - 1 >= 0 && grid[curI - 1][curJ] == 1) {
                queue.offer(new int[]{curI - 1, curJ});
            }
            if (curI + 1 < m && grid[curI + 1][curJ] == 1) {
                queue.offer(new int[]{curI + 1, curJ});
            }
            if (curJ - 1 >= 0 && grid[curI][curJ - 1] == 1) {
                queue.offer(new int[]{curI, curJ - 1});
            }
            if (curJ + 1 < n && grid[curI][curJ + 1] == 1) {
                queue.offer(new int[]{curI, curJ + 1});
            }
        }
        return ans;
    }

}
