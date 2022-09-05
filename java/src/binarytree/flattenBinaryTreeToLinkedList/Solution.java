package binarytree.flattenBinaryTreeToLinkedList;

import binarytree.TreeNode;

/**
 * 114. 二叉树展开为链表
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 处理子树
        flatten(root.left);
        flatten(root.right);

        // 后序位置
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将左子树作为右子树
        root.left = null;
        root.right = left;

        // 把原先的右子树拼接到现在的右子树上
        // 先移动都右节点的最后一个节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // 接上
        p.right = right;
    }
}