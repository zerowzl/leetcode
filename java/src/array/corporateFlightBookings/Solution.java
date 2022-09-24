package array.corporateFlightBookings;

/**
 * 1109. 航班预订统计
 */
class Solution {

    /**
     * 差分数组，构建一个差分数组，diff 。内容如下：
     * length = nums.length
     * diff[i] = nums[i] - nums[i-1] ，也就是差分的由来
     * 还原操作：res[i] = res[i-1] + diff[i]
     * 更新操作：如要更新 nums[i..j] 全部加2，则只需要对 diff[i] += 2，diff[j+1] -=2。
     * 原理是：还原的时候是通过前一个值累加下去的，也就是说修改了前一个值，
     * 比如 +2，后面的计算出的结果都是在原来基础上+2的。然后在区间结束后的开始元素进行还原。
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