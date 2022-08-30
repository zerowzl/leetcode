package binarysearch.findFirstAndLastPositionOfElementInSortedArray;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution {
    /**
     * 二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = searchLeft(nums, target);
        int rightIndex = searchRight(nums, target);
        return new int[]{leftIndex, rightIndex};
    }

    int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // 左闭右开区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 继续从左边查找
            if (nums[mid] == target) {
                right = mid;
                // 继续从右边查找
            } else if (nums[mid] < target) {
                left = mid + 1;
                // 继续从左边查找
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 防止搜索到最后都没有找到
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // 左闭右开区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 继续从右边查找
                // 注意这里的+1，不+1会死循环
                left = mid + 1;
                // 继续从右边查找
            } else if (nums[mid] < target) {
                left = mid + 1;
                // 继续从左边查找
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 等于等于的时候加1了，所以结果需要减一
        if (left - 1 < 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
}