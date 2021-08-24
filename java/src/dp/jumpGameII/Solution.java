package dp.jumpGameII;

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 *
 * @author Dave Wang
 */
class Solution {

    public int jump(int[] nums) {
        int[] step = new int[nums.length];
        Arrays.fill(step, Integer.MAX_VALUE);
        step[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int range = nums[i];
            // 当前元素可以跳跃的范围
            for (int j = 1; j <= range; j++) {
                int currIndex = i + j;
                if (currIndex >= nums.length) {
                    break;
                }
                step[currIndex] = Math.min(step[currIndex], step[i] + 1);
            }
        }
        return step[step.length - 1];
    }
}