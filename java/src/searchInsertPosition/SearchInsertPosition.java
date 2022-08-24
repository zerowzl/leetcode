package searchInsertPosition;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">搜索插入位置</a>
 *
 * @author Dave Wang
 */
public class SearchInsertPosition {

    /**
     * 二分查找，找到第一个大于等于的索引
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            /*
                这里比较好地解题思路是，没有针对各种情况特殊去判断；
                而是通过使用 ans 变量每次记录下值，让每一种情况都能适用。
             */
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
