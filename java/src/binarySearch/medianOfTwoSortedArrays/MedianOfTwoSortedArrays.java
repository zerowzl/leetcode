package binarySearch.medianOfTwoSortedArrays;

/* *****************************************************************************

4. 寻找两个正序数组的中位数
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2

示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

示例 3：
输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000

示例 4：
输入：nums1 = [], nums2 = [1]
输出：1.00000

示例 5：
输入：nums1 = [2], nums2 = []
输出：2.00000

提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

*******************************************************************************/

/* *****************************************************************************

题解：
因为数组有有序的，不需要遍历所有的，只要得到中位数的值就可以。

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(1)

*******************************************************************************/


/**
 * @author Dave Wang
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int nums1Index = 0, nums2Index = 0;
        int ans1 = 0, ans2 = 0;

        for (int i = 0; i <= length / 2; i++) {
            ans1 = ans2;
            // nums1Index < nums1.length 表示数组1还有元素
            // nums2Index > nums2.length 表示数组2已经没有元素了
            // nums1[nums1Index] <  nums2[nums2Index] 表示数组1中的元素值比较小
            if (nums1Index < nums1.length && (nums2Index >= nums2.length || nums1[nums1Index] < nums2[nums2Index])) {
                ans2 = nums1[nums1Index];
                nums1Index++;
            } else {
                ans2 = nums2[nums2Index];
                nums2Index++;
            }
        }

        boolean odd = length % 2 == 1;
        if (odd) {
            return ans2;
        } else {
            return (ans1 + ans2) / 2.0;
        }
    }


}
