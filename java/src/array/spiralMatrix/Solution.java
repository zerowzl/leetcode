package array.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 先固定四个点
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int left = 0;
        int down = m - 1;
        int right = n - 1;
        int count = 0;
        List<Integer> ans = new ArrayList<>(m * n);
        while (count < m * n) {
            if (up <= down) {
                // 从左向右
                for (int i = left; i <= right; i++) {
                    count++;
                    ans.add(matrix[up][i]);
                }
                up++;
            }

            if (left <= right) {
                // 从上向下
                for (int i = up; i <= down; i++) {
                    count++;
                    ans.add(matrix[i][right]);
                }
                right--;
            }

            if (up <= down) {
                // 从右向左
                for (int i = right; i >= left; i--) {
                    count++;
                    ans.add(matrix[down][i]);
                }
                down--;
            }

            if (left <= right) {
                // 从下向上
                for (int i = down; i >= up; i--) {
                    count++;
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}