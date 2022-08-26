package array.removeElement;

/**
 * 27. 移除元素
 */
class Solution {
    /**
     * 双指针:
     * 使用快慢指针 fast 和 slow，fast 先走，每走一步判断一下和 val 的值，
     * 如果不相等就赋值给 slow 并移动 slow。最后所有不等于 val 值的元素都在前面了。
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}