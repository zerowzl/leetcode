package array.spiralMatrix2;

/**
 * 59. 螺旋矩阵 II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0;
        int left = 0;
        int down = n - 1;
        int right = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (up <= down) {
                // 从左向右
                for (int i = left; i <= right; i++) {
                    matrix[up][i] = num++;
                }
                up++;
            }

            if (left <= right) {
                // 从上向下
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }

            if (up <= down) {
                // 从右向左
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = num++;
                }
                down--;
            }

            if (left <= right) {
                // 从下向上
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}