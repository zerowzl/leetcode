package binarytree.binaryTreeInorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traverse(root.left, res);
        // 中序遍历
        res.add(root.val);
        traverse(root.right, res);
    }
}