package array.shortestUnsortedContinuousSubarray;

/* *****************************************************************************

581. 最短无序连续子数组
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
请你找出符合题意的 最短 子数组，并输出它的长度。

示例 1：
输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

示例 2：
输入：nums = [1,2,3,4]
输出：0
 
示例 3：
输入：nums = [1]
输出：0

提示：
 1 <= nums.length <= 104
 -105 <= nums[i] <= 105 
 
进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    leftMin = Math.min(leftMin, i);
                    rightMax = Math.max(rightMax, j);
                }
            }
        }

        return leftMin == Integer.MAX_VALUE ? 0 : rightMax - leftMin + 1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            // 从左向右, 找右边小于左边的
            if (maxn > nums[i]) {
                right = i;
            } else {
                // 右边大于左边的, 需要更新当前左边最大值
                maxn = nums[i];
            }
            // 从右向左, 找左边大于右边的
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                // 左边小于右边的, 需要更新当前右边最小值
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}
