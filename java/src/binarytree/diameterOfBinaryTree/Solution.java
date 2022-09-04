package binarytree.diameterOfBinaryTree;

import binarytree.TreeNode;

/**
 * 543. 二叉树的直径
 */
class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        // 递归
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // 最大直径
        int currMaxDiameter = leftDepth + rightDepth;
        maxDiameter = Math.max(currMaxDiameter, maxDiameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}