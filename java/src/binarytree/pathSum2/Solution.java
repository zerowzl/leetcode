package binarytree.pathSum2;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        pathSum(root, targetSum, new LinkedList<>());
        return res;
    }

    public void pathSum(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        int newSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (newSum == 0) {
                // 找到一条路径
                path.addLast(root.val);
                res.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }

        // 维护路径
        // 前序添加路径
        path.addLast(root.val);
        pathSum(root.left, newSum, path);
        // 后序删除添加的路径
        path.removeLast();

        path.addLast(root.val);
        pathSum(root.right, newSum, path);
        path.removeLast();
    }
}