package binarytree.binaryTreePreorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;

    }

    private void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }

}