package binarytree.balancedBinaryTree;

import binarytree.TreeNode;

/**
 * 110. 平衡二叉树
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalance;
    }

    // 是否平衡标识
    private boolean isBalance = true;

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        // 后序位置进行左右子树的高度判断
        if (Math.abs(leftMaxDepth - rightMaxDepth) > 1) {
            isBalance = false;
            return -1;
        }
        // 计算左右子树的高度，取最高的一个
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

}