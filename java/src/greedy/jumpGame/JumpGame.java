package greedy.jumpGame;

/* *****************************************************************************

55. 跳跃游戏
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。

示例 1：
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

示例 2：
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

提示：
1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105

*******************************************************************************/

/* *****************************************************************************

题解：
贪心：维护一个最大可达距离，遍历数组，如果当前节点小于等于“最大可达距离” 说明当前节点可以达到，则更新“最大可达距离”。

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(1)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        // 最远可达
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前在范围内
            if (i <= max) {
                // 更新
                max = Math.max(max, (nums[i] + i));
                // 最后可达
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
