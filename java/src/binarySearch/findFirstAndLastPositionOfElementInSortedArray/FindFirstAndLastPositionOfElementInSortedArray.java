package binarySearch.findFirstAndLastPositionOfElementInSortedArray;

/* *****************************************************************************

34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？


示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]


提示：
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109

*******************************************************************************/

/* *****************************************************************************

题解 1：
遍历一次就可以

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(1)

题解 2：
由于数组已经排序，因此整个数组是单调递增的，我们可以利用二分法来加速查找的过程。
考虑 target 开始和结束位置，其实我们要找的就是数组中「第一个等于 target 的位置」（记为 leftIdx）和「第一个大于 target 的位置减一」（记为 rightIdx）。
二分查找中，寻找 leftIdx 即为在数组中寻找第一个大于等于 target 的下标，寻找 rightIdx 即为在数组中寻找第一个大于 target 的下标，然后将下标减一。
两者的判断条件不同，为了代码的复用，我们定义 binarySearch(nums, target, lower) 表示在 nums 数组中二分查找 target 的位置，
如果 lower 为 true，则查找第一个大于等于 target 的下标，否则查找第一个大于 target 的下标。
最后，因为 target 可能不存在数组中，因此我们需要重新校验我们得到的两个下标 leftIdx 和 rightIdx，看是否符合条件，
如果符合条件就返回 [leftIdx,rightIdx]，不符合就返回 [-1,-1]。

复杂度分析：
时间复杂度：O(log n)
空间复杂度：O(1)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = -1;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            // 大于就结束循环
            if (nums[i] > target) {
                break;
            }
            // 相等
            if (nums[i] == target) {
                // 如果first = -1，说明是第一个
                if (first == -1) {
                    first = i;
                }
                // 最后一个元素了，设置last
                if (i == nums.length - 1) {
                    last = i;
                    break;
                }
                // 看下后面一个是不是还是相等的，如果不是，可以结束循环，设置当前下标为 last
                if (nums[i + 1] != target) {
                    last = i;
                    break;
                }
            }
        }

        return new int[]{first, last};
    }

    public int[] searchRangeV2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        // 第一个大于的下标 -1（有可能该下标位元素的值并不是目标值）因此在下面要多判断一下
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        // ans 先定义为 nums 长度，返回后会判断
        int ans = nums.length;
        while (left <= right) {
            // 获取中点下标
            int mid = (left + right) / 2;
            // nums[mid] > target 中点元素大于目标值，就继续搜索数组的左边
            // (lower && nums[mid] >= target) 如果是lower 就是要找第一个大于等于的，那么等于的时候也需要继续搜索数组的左边
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                // 小于的情况，搜索右边
                left = mid + 1;
            }
        }
        return ans;
    }

}
