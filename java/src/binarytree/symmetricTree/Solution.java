package binarytree.symmetricTree;

import binarytree.TreeNode;

/**
 * 101. 对称二叉树
 */
class Solution {
    /**
     * DFS
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            }
        }
    }
}