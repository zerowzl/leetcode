package binarytree.minimumDepthOfBinaryTree;

import binarytree.TreeNode;

/**
 * 111. 二叉树的最小深度
 */
class Solution {
    /**
     * DFS
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 1);

    }

    public int minDepth(TreeNode root, int ans) {
        if (root.left == null && root.right == null) {
            return ans;
        }
        ans++;
        if (root.left == null) {
            return minDepth(root.right, ans);
        }
        if (root.right == null) {
            return minDepth(root.left, ans);
        }

        return Math.min(minDepth(root.left, ans), minDepth(root.right, ans));
    }
}