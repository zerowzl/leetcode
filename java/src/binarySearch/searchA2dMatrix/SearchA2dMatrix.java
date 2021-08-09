package binarySearch.searchA2dMatrix;

/* *****************************************************************************

74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

示例 1：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true

示例 2：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false
 
提示：
 m == matrix.length
 n == matrix[i].length 
 1 <= m, n <= 100 
 -104 <= matrix[i][j], target <= 104 

*******************************************************************************/


/**
 * @author Dave Wang
 */
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int low = 0, height = m - 1;

        // 第一维, 找第一个小于等于的
        while (low <= height) {
            int mid = low + ((height - low) >> 1);
            if (matrix[mid][0] > target) {
                height = mid - 1;
            } else if (matrix[mid][0] < target) {
                if (mid == m - 1 || matrix[mid + 1][0] > target) {
                    // 找到了
                    int[] arr = matrix[mid];
                    low = 0;
                    height = arr.length - 1;
                    while (low <= height) {
                        int mid2 = low + ((height - low) >> 1);
                        if (arr[mid2] == target) {
                            return true;
                        } else if (arr[mid2] < target) {
                            low = mid2 + 1;
                        } else {
                            height = height - 1;
                        }
                    }
                    return false;
                } else {
                    low = mid + 1;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
