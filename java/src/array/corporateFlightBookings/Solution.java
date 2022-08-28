package array.corporateFlightBookings;

/**
 * 1109. 航班预订统计
 */
class Solution {

    /**
     * 差分数组
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.increment(i, j, val);
        }
        return difference.getRes();
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