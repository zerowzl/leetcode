package array.searchInsertPosition;

/* *****************************************************************************

35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2

示例 2:
输入: [1,3,5,6], 2
输出: 1

示例 3:
输入: [1,3,5,6], 7
输出: 4

示例 4:
输入: [1,3,5,6], 0
输出: 0

*******************************************************************************/


/* *****************************************************************************

题解：
可以转化为求第一个大于等于给定值的元素

复杂度分析：
时间复杂度：O(log n)
空间复杂度：O(1)

*******************************************************************************/


/**
 * @author Dave Wang
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0] < target ? 1 : 0;
        }

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 找到了就返回
            if (nums[mid] == target) {
                return mid;
                // 小于就继续查右半区
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // 大于，如果已经是第一个元素了 或者 前一个元素比 target 要小，就没必要找了
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    // 否则继续在左半区查找
                    high = mid - 1;
                }
            }
        }

        // 如果没找到，说明 target 大于元素中最大的数
        return nums.length;
    }

}
