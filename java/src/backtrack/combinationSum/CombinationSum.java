package backtrack.combinationSum;

/* *****************************************************************************

39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。

示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
 
示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
 [2,2,2,2],
 [2,3,3],
 [3,5]
] 

提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500

*******************************************************************************/

/* *****************************************************************************

题解：
面对一个元素，可以选择用，也可以选择不用，可以使用回溯算法来解决。
因为元素可以重复使用，当选择用的时候递归调用时 index 还是当前元素；当选择不用的时候 index + 1。
终止条件有三个，1）target = 0，说明找到了解；2）target < 0，说明当前选择不符合条件；3）index = 待选元素长度，说明没有元素可以用了。

复杂度分析：
时间复杂度：O(S)，其中 S 为所有可行解的长度之和。从分析给出的搜索树我们可以看出时间复杂度取决于搜索树所有叶子节点的深度之和，即所有可行解的长度之和。
在这题中，我们很难给出一个比较紧的上界，我们知道 O(n×2^n) 是一个比较松的上界，即在这份代码中，nn 个位置每次考虑选或者不选，如果符合条件，就加入答案的时间代价。
但是实际运行的时候，因为不可能所有的解都满足条件，递归的时候我们还会用 target - candidates[idx] >= 0 进行剪枝，所以实际运行情况是远远小于这个上界的。

空间复杂度：O(target)。除答案数组外，空间复杂度取决于递归的栈深度，在最差情况下需要递归 O(target) 层。

*******************************************************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackV2(candidates, target, res, new LinkedList<>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> ans, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if (target < 0) {
            return;
        }

        // 没有元素可以选了
        if (index == candidates.length) {
            return;
        }

        // 不用
        backtrack(candidates, target, res, ans, index + 1);

        // 用
        if (target - candidates[index] >= 0) {
            ans.add(candidates[index]);
            backtrack(candidates, target - candidates[index], res, ans, index);
            // 恢复 ans
            ans.remove(ans.size() - 1);
        }
    }


    private void backtrackV2(int[] candidates, int target, List<List<Integer>> res, List<Integer> ans, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index >= candidates.length) {
            return;
        }

        // 用
        ans.add(candidates[index]);
        backtrackV2(candidates, target - candidates[index], res, ans, index);
        ans.remove(ans.size() - 1);

        // 不用
        backtrackV2(candidates, target, res, ans, index + 1);
    }
}