package array.removeDuplicatesFromSortedArray;

/**
 * 26. 删除有序数组中的重复项
 */
class Solution {
    /**
     * 双指针:
     * 使用快慢指针 fast 和 slow，fast 先走，每走一步判断一下和 slow 的值，
     * 如果不相等就移动 slow 并将 fast 赋值给 slow。最后所有不相等的值都在最前面了。
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}