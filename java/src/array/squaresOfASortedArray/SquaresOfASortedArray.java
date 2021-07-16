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

import java.util.Arrays;

/**
 * @author Dave Wang
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }

        // low --> 负数, high --> 正数
        int low = -1;
        int high = -1;
        for (int i = 0; i < nums.length; i++) {
            // 找到第一个正数就结束了
            if (nums[i] >= 0) {
                high = i;
                break;
            } else {
                // 负数需要继续找
                // 已经是最后了, 就没必要继续了
                if (i == nums.length - 1) {
                    low = i;
                } else {
                    // 看一下后面一个是不是正数, 如果是, 当前就是最后一个负数
                    if (nums[i + 1] >= 0) {
                        low = i;
                    }
                }
            }
        }

        int[] ans = new int[nums.length];
        int i = 0;
        while ((low >= 0) && (high >= 0 && high < nums.length)) {
            int lowValue = nums[low];
            int highValue = nums[high];
            if (lowValue * lowValue < highValue * highValue) {
                ans[i] = lowValue * lowValue;
                low--;
            } else {
                ans[i] = highValue * highValue;
                high++;
            }
            i++;
        }

        // 看看 low 和 high 谁还有剩
        if (low >= 0) {
            while (low >= 0) {
                int value = nums[low];
                ans[i] = value * value;
                i++;
                low--;
            }
        }

        if (high >= 0 && high < nums.length) {
            while (high < nums.length) {
                int value = nums[high];
                ans[i] = value * value;
                i++;
                high++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {







    }

}
