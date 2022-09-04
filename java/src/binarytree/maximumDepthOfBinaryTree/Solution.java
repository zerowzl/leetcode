package binarytree.maximumDepthOfBinaryTree;

import binarytree.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // 递归
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}












