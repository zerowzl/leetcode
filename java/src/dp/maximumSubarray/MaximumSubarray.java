package dp.maximumSubarray;

/* *****************************************************************************

53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 

示例 1： 
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 
示例 2： 
输入：nums = [1]
输出：1

示例 3： 
输入：nums = [0]
输出：0
 
示例 4： 
输入：nums = [-1]
输出：-1
 
示例 5： 
输入：nums = [-100000]
输出：-100000

提示： 
 1 <= nums.length <= 3 * 104 
 -105 <= nums[i] <= 105

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class MaximumSubarray {

    /*
        # 状态转移图
            -2	1	-3	4	-1	2	1	-5	4
        -2	(-2) = -2	x	x	x	x	x	x	x	x
        1	(-2, 1) = -1	(1) = 1	x	x	x	x	x	x	x
        -3	(-2, 1, -3) = -4	(1, -3) = -2	(-3) = -3	x	x	x	x	x	x
        4	(-2, 1, -3, 4) = 0	(1, -3, 4) = 2	(-3, 4) = 1	(4) = 4	x	x	x	x	x
        -1	(-2, 1, -3, 4, -1) = -1	(1, -3, 4, -1) = 1	(-3, 4, -1) = 0	(4, -1) = 3	(-1) = -1	x	x	x	x
        2	(-2, 1, -3, 4, -1, 2) = 1	(1, -3, 4, -1, 2) = 3	(-3, 4, -1, 2) = 2	(4, -1, 2) = 4	(-1, 2) = 1	(2) = 2	x	x	x
        1	(-2, 1, -3, 4, -1, 2, 1) = 2	(1, -3, 4, -1, 2, 1) = 4	(-3, 4, -1, 2, 1) = 3	(4, -1, 2, 1) = 6	(-1, 2, 1) = 2	(2, 1) = 3	(1) = 1	x	x
        -5	(-2, 1, -3, 4, -1, 2, 1, -5) = -3	(1, -3, 4, -1, 2, 1, -5) = -1	(-3, 4, -1, 2, 1, -5) = -2	(4, -1, 2, 1, -5) = 1	(-1, 2, 1, -5) = -3	(2, 1, -5) = -2	(1, -5) = -4	(-5) = -5	x
        4	(-2, 1, -3, 4, -1, 2, 1, -5, 4) = 1	(1, -3, 4, -1, 2, 1, -5, 4) = 3	(-3, 4, -1, 2, 1, -5, 4) = 2	(4, -1, 2, 1, -5, 4) = 5	(-1, 2, 1, -5, 4) = 1	(2, 1, -5, 4) = 2	(1, -5, 4) = 0	(-5, 4) = -1	(4) = 4
     */

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // 动态规划的解法
        int[][] value = new int[nums.length][nums.length];
        value[0][0] = nums[0];
        int max = nums[0];
        for (int i = 0; i < value.length; i++) {
            for (int j = i; j < value.length; j++) {
                // 相等就用当前元素
                if (i == j) {
                    value[i][j] = nums[i];
                    // j > i, 前一个序列的结果 + 当前元素
                } else {
                    value[i][j] = value[i][j - 1] + nums[j];
                }

                max = Integer.max(max, value[i][j]);
            }
        }

        return max;
    }


    /**
     * 动态规划更省内存的解法(使用一个数组)
     */
    public int maxSubArrayV2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int[] value = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    value[j] = nums[i];
                } else {
                    value[j] = value[j - 1] + nums[j];
                }

                max = Integer.max(max, value[j]);
            }
        }

        return max;
    }

    /**
     * 官方题解
     * pre = Integer.max(pre + num, num); // 前面加起来都没有当前的大, 就丢弃
     */
    public int maxSubArrayV3(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Integer.max(pre + num, num);
            max = Integer.max(max, pre);
        }
        return max;
    }

}
