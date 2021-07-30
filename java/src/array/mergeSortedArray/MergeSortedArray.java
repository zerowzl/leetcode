package array.mergeSortedArray;

/* *****************************************************************************

88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
  初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
 
示例 2：
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]

提示：
 nums1.length == m + n
 nums2.length == n 
 0 <= m, n <= 200 
 1 <= m + n <= 200 
 -109 <= nums1[i], nums2[i] <= 109 

*******************************************************************************/

/* *****************************************************************************

题解：
Sort

复杂度分析：
时间复杂度：O(n log n)
空间复杂度：O(1)

*******************************************************************************/


import java.util.Arrays;

/**
 * @author Dave Wang
 */
public class MergeSortedArray {

    public void mergeSort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }

        Arrays.sort(nums1);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int i = 0, j = 0, t = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[t] = nums1[i];
                i++;
            } else {
                temp[t] = nums2[j];
                j++;
            }
            t++;
        }


        if (i < m) {
            while (i < m) {
                temp[t] = nums1[i];
                i++;
                t++;
            }
        }

        if (j < n) {
            while (j < n) {
                temp[t] = nums2[j];
                j++;
                t++;
            }
        }

        for (int k = 0; k < temp.length; k++) {
            nums1[k] = temp[k];
        }
    }

}
