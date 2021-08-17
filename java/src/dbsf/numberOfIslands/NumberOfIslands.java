package dbsf.numberOfIslands;

/* *****************************************************************************

200. 岛屿数量

*******************************************************************************/

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class NumberOfIslands {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 深度优先
     * 1. boolean[][] path 记录是否扫描过
     * 2. 遍历 char[][] grid
     * 3. 节点扫描过 或者 节点是 0 跳过
     * 4. ans++, 继续扫描直到四周都为水
     */
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] path = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (path[i][j]) {
                    continue;
                }
                if (grid[i][j] == '0') {
                    continue;
                }
                ans++;
                dfs(i, j, grid, m, n, path);
            }
        }

        return ans;
    }

    private void dfs(int i, int j, char[][] grid, int m, int n, boolean[][] path) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (path[i][j]) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }
        path[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, grid, m, n, path);
        }
    }

}
