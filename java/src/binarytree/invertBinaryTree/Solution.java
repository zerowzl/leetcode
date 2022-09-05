package binarytree.invertBinaryTree;

import binarytree.TreeNode;

/**
 * 226. 翻转二叉树
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode bfs(TreeNode root) {
        if (root == null) {
            return root;
        }

        // 先交换子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        // 继续处理子树
        bfs(root.left);
        bfs(root.right);
        return root;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 先处理子树
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        // 再交换子节点
        root.left = right;
        root.right = left;
        return root;
    }
}