package com.zerowzl.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列.
 *
 * @author wangzhiliang
 */
public class Permutations {


    /**
     * 不重复的全排列，就是 n!个。
     * 使用一个列表记录未使用的元素，如果没有未使用的元素，则添加到答案中。
     * 如果还有未使用的元素，则按顺序选择一个元素，然后删除该元素，继续选择（递归）剩下的元素，直到元素被选完。
     *
     * @param nums 数组
     * @return 全排列的列表
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> unused = new ArrayList<>();
        for (int num : nums) {
            unused.add(num);
        }
        permute(ans, new ArrayList<>(), unused);
        return ans;
    }

    public void permute(List<List<Integer>> res, List<Integer> temp, List<Integer> unused) {
        // 全部都选了添加到响应中
        if (unused.isEmpty()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < unused.size(); i++) {
            // 添加到临时列表
            Integer value = unused.get(i);
            temp.add(value);
            // 已选，不用再用
            unused.remove(value);
            // 递归
            permute(res, temp, unused);
            // 删除递归添加的元素
            temp.remove(temp.size() - 1);
            // 恢复使用
            unused.add(i, value);
        }
    }

}
