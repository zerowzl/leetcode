package array.moveZeroes;

/**
 * 283. 移动零
 */
class Solution {
    /**
     * 双指针：使用【27. 移除元素】中的方法，然后在数组的后面赋值0。
     */
    public void moveZeroes(int[] nums) {
        int element = removeElement(nums, 0);

        while (element < nums.length) {
            nums[element] = 0;
            element++;
        }
    }

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