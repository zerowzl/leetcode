package dbsf.zeroOneMatrix;

/* *****************************************************************************

542. 01 矩阵
给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
两个相邻元素间的距离为 1 。

示例 1：
输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
输出：[[0,0,0],[0,1,0],[0,0,0]]
 
示例 2：
输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
输出：[[0,0,0],[0,1,0],[1,2,1]]
 
提示：
 m == mat.length
 n == mat[i].length 
 1 <= m, n <= 104 
 1 <= m * n <= 104 
 mat[i][j] is either 0 or 1. 
 mat 中至少有一个 0

*******************************************************************************/

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dave Wang
 */
public class ZeroOneMatrix {

    /**
     * 简化四个方向的移动
     */
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        // 1.将所有的 0 加入队列
        Queue<int[]> queue = new LinkedList<>();

        // 2.记录是否处理过
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] seen = new boolean[m][n];
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // 是 0 就入队
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }

        // 3. 每次处理[0]相邻的单元格
        //    所有的0处理完后处理所有的[1]相邻的单元格
        //    .......
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            // 四个方向, 4次
            for (int k = 0; k < 4; k++) {
                int x = dirs[k][0] + i;
                int y = dirs[k][1] + j;
                if (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y]) {
                    queue.offer(new int[]{x, y});
                    seen[x][y] = true;
                    ans[x][y] = ans[i][j] + 1;
                }
            }
        }
        return ans;
    }
}
