package array.nextPermutation;

/* *****************************************************************************

31.下一个排列
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]

示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]

示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]

示例 4：
输入：nums = [1]
输出：[1]


提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100

*******************************************************************************/

/* *****************************************************************************

题解：
找一对较小值和较大值，较小值 尽量靠右，较大值 尽量小，然后交换 较小值 和 较大值。

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(1)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // 首先从后向前查找较小值
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 然后找较大值
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }

            // 交换较小值和较大值
            swap(nums, i, j);
        }

        // 最后记得反转较小值后面的元素
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
