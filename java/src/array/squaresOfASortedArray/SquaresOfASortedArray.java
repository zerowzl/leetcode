package array.squaresOfASortedArray;

/* *****************************************************************************

977. 有序数组的平方
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]

示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]


提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序

进阶：
请你设计时间复杂度为 O(n) 的算法解决本问题

*******************************************************************************/

/* *****************************************************************************

题解：
因为负数的平方计算得出的是正数, 关键是找到最小的正数和最大的负数, 然后使用双指针

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int min = -1;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                min = i;
                max = min - 1;
                break;
            } else {
                if (i == nums.length - 1) {
                    max = i;
                    break;
                }
            }
        }

        int[] ans = new int[nums.length];
        int i = 0;
        while (max > -1 && (min > -1 && min < nums.length)) {
            int maxValue = nums[max] * nums[max];
            int minValue = nums[min] * nums[min];
            if (maxValue < minValue) {
                ans[i] = maxValue;
                max--;
            } else {
                ans[i] = minValue;
                min++;
            }
            i++;
        }

        while (max > -1) {
            int maxValue = nums[max] * nums[max];
            ans[i] = maxValue;
            max--;
            i++;
        }

        while (min > -1 && min < nums.length) {
            int minValue = nums[min] * nums[min];
            ans[i] = minValue;
            min++;
            i++;
        }
        return ans;
    }

}
