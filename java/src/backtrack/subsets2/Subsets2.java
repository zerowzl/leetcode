package backtrack.subsets2;

/* *****************************************************************************

90. 子集 II
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。


示例 1：
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

示例 2：
输入：nums = [0]
输出：[[],[0]]


提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10

*******************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dave Wang
 */
public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(false, 0, nums, temp, ans);
        return ans;
    }

    private void dfs(boolean chosePre, int i, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        dfs(false, i + 1, nums, temp, ans);
        if (!chosePre && i > 0 && nums[i - 1] == nums[i]) {
            return;
        }
        temp.add(nums[i]);
        dfs(true, i + 1, nums, temp, ans);
        temp.remove(temp.size() - 1);
    }


}
