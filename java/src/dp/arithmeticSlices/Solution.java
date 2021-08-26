package dp.arithmeticSlices;

/**
 * @author Dave Wang
 */
class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, curr = 0;
        // 从第三个元素开始就可以
        for (int i = 2; i < nums.length; i++) {
            // 三个元素的差一样
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                // 先将当前次答案+1
                // 再更新 ans + curr，因为长度+1的时候，ans 不止是1还要加上上一个长度的curr
                ans += ++curr;
            } else {
                // 重新开始
                curr = 0;
            }
        }
        return ans;
    }
}