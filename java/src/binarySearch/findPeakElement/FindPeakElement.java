package binarySearch.findPeakElement;

/* *****************************************************************************

162. 寻找峰值
峰值元素是指其值大于左右相邻值的元素。 
给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
你可以假设 nums[-1] = nums[n] = -∞ 。

示例 1：
输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。 

示例 2：
输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5 
解释：你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5， 其峰值元素为 6。

提示：
 1 <= nums.length <= 1000
 -231 <= nums[i] <= 231 - 1 
 对于所有有效的 i 都有 nums[i] != nums[i + 1] 

进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 首元素
            if (i == 0) {
                // 只有一个直接返回
                if (i == nums.length - 1) {
                    return i;
                } else {
                    // 如果比后面的大返回, 不然继续
                    if (nums[i] > nums[i + 1]) {
                        return i;
                    }
                }
                // 中间元素
            } else if (i < nums.length - 1) {
                // 比两边的大直接返回, 不然就继续找
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            } else {
                // 最后一个元素比前一个元素大就返回, 不然就返回 -1
                if (nums[i - 1] < nums[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int findPeakElementBS(int[] nums) {
        int low = 0;
        int height = nums.length - 1;

        while (low <= height) {
            if (low == height) {
                return low;
            }
            int mid = low + ((height - low) >> 1);
            // 峰值一定在大的那边
            if (nums[mid] > nums[mid + 1]) {
                height = mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
