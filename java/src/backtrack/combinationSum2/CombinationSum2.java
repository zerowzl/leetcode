package backtrack.combinationSum2;

/* *****************************************************************************

40.组合总和2
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
 candidates 中的每个数字在每个组合中只能使用一次。 
 注意：解集不能包含重复的组合。 

示例 1: 
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
] 

示例 2: 
输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
] 

提示: 
 1 <= candidates.length <= 100 
 1 <= candidates[i] <= 50 
 1 <= target <= 30 

*******************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dave Wang
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> ans, int[] candidates, int target, int index, int currSum) {
        if (currSum == target) {
            res.add(new ArrayList<>(ans));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            System.out.println("=============================");
            System.out.println("res: " + res);
            System.out.println("ans: " + ans);
            System.out.println("index: " + index);
            System.out.println("i: " + i);
            System.out.println("currSum: " + currSum);
            // 关键是这句，如果处于同一层的当前元素和前一个元素一样就跳过
            if (i > index && candidates[i] == candidates[i - 1]) {
                System.out.println("==============跳过===============\n");
                continue;
            }
            System.out.println("=============================\n");
            int sum = candidates[i] + currSum;
            // 只处理小于等于的，因为已经排好序了，大于了后面也没必要看了
            if (sum <= target) {
                ans.add(candidates[i]);
                backtrack(res, ans, candidates, target, i + 1, sum);
                ans.remove(ans.size() - 1);
            } else {
                break;
            }
        }
    }

}
