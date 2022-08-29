package array.rotateImage;

/**
 * 48. 旋转图像
 */
class Solution {
    /**
     * 先沿着对角线把行转列，再翻转每一列
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 沿着对角线把行转列
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 翻转每一列
        for (int[] nums : matrix) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }
}