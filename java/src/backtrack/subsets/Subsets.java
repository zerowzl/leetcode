package backtrack.subsets;

/* *****************************************************************************

78. 子集
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例 2：
输入：nums = [0]
输出：[[],[0]]

提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同

*******************************************************************************/

import sun.security.provider.DSAKeyFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, temp, ans);
        return ans;
    }

    private void dfs(int i, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(i + 1, nums, temp, ans);
        temp.remove(temp.size() - 1);
        dfs(i + 1, nums, temp, ans);
    }


}
