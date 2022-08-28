package array.carPooling;

/**
 * 1094. 拼车
 */
class Solution {

    /**
     * 差分数组
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            difference.increment(i, j, val);
        }
        int[] res = difference.getRes();
        for (int i : res) {
            if (i > capacity) {
                return false;
            }
        }
        return true;
    }

    static class Difference {
        // 差分数组
        int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] getRes() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}