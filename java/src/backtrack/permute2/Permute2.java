package backtrack.permute2;

/* *****************************************************************************

46. 全排列2
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

提示：
1 <= nums.length <= 8
-10 <= nums[i] <= 10

*******************************************************************************/

/* *****************************************************************************

题解1：
一组数的全排列，可以使用回溯的思想，递归的编程方式来解决。
将问题分解为选择一个元素后，在剩余未选元素中继续选择。解的数量是 n!
因为元素存在重复，并且要求解中不重复，
第一步我们先对数组进行排序，确保重复的元素是相邻的；
第二步使用 `i != 0 && nums.get(i).equals(nums.get(i - 1))`来判断元素是否已经使用。

复杂度分析：
时间复杂度：O(n * n!)
空间复杂度：O(n)

*******************************************************************************/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列2
 *
 * @author Dave Wang
 */
public class Permute2 {


    /**
     * 一组数的全排列，可以使用回溯的思想，递归的编程方式来解决。
     * 将问题分解为选择一个元素后，在剩余未选元素中继续选择。解的数量是 n!
     * 因为元素存在重复，并且要求解中不重复，
     * 第一步我们先对数组进行排序，确保重复的元素是相邻的；
     * 第二步使用 `i != 0 && nums.get(i).equals(nums.get(i - 1))`来判断元素是否已经使用。
     * 终止条件，可用元素全部被选择
     *
     * @param nums 待选元素数组
     * @return 所有的解
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        backtrack(list, res, new ArrayList<>());
        return res;
    }

    private void backtrack(List<Integer> nums, List<List<Integer>> res, ArrayList<Integer> ans) {
        if (nums.isEmpty()) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (i != 0 && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }

            ArrayList<Integer> newAns = (ArrayList<Integer>) ans.clone();
            newAns.add(nums.get(i));
            ArrayList<Integer> newNums = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }
                newNums.add(nums.get(j));
            }
            backtrack(newNums, res, newAns);
        }
    }


}

