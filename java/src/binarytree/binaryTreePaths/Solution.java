package binarytree.binaryTreePaths;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        traverse(root, new LinkedList<>(), res);
        return res;
    }

    private void traverse(TreeNode root, LinkedList<Integer> path, List<String> ans) {
        // 基本情况
        if (root.left == null && root.right == null) {
            path.add(root.val);
            StringBuilder str = new StringBuilder();
            str.append(path.get(0));
            for (int i = 1; i < path.size(); i++) {
                str.append("->").append(path.get(i));
            }
            ans.add(str.toString());
            return;
        }
        // 前序
        path.add(root.val);
        if (root.left != null) {
            traverse(root.left, path, ans);
            // 回来的时候删除上一次添加的
            path.removeLast();
        }
        if (root.right != null) {
            traverse(root.right, path, ans);
            // 回来的时候删除上一次添加的
            path.removeLast();
        }
    }
}