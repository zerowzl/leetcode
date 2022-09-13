package binarytree.pathSum;

import binarytree.TreeNode;

/**
 * 112. 路径总和
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int newSum = targetSum - root.val;
        if (newSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }

}