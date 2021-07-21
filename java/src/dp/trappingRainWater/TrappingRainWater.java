package dp.trappingRainWater;

/* *****************************************************************************

42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例 2：
输入：height = [4,2,0,3,2,5]
输出：9

提示：
n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105

*******************************************************************************/

/* *****************************************************************************

题解1：
暴力法
1.首先我们需要明确的一点是：下标 i 所能接的雨水 = Min（左边最大，右边最大）- Height[i];
2.我们扫描数组来计算每个下标的对应的值

复杂度分析：
时间复杂度：O(n^2)
空间复杂度：O(1)

题解2：
动态规划
1.由上个解我们知道，关键的地方在于找到 i 左右两边的最大值，那么其实我们可以先进行两次扫描分别记录下左边和右边每个下标的最大值
2.然后使用一次扫描就可以

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class TrappingRainWater {

    public int trapForce(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = height[i];
            int maxRight = height[i];
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }

        return ans;
    }

    public int trapDP(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;

        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 1; i < length - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 1、使用两个指针 left 和 right 向中间扫描
     * 2、每次记录下 leftMax 和 rightMax
     * 3-1、如果 height[left] < height[right]，那么必然有存在 leftMax < rightMax，那么也就是说可以以 leftMax - height[left]
     * 3-2、如果 height[left] >= height[right]，那么必然有存在 rightMax < leftMax，那么也就是说可以以 rightMax - height[right]
     */
    public int trapDoublePrint(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, ans = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }

}
