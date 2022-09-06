package bst.validateBinarySearchTree;

import binarytree.TreeNode;

/**
 * 98. 验证二叉搜索树
 */
class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // 退出情况
        if (root == null) {
            return true;
        }
        // 判断是否符合左子树的值要求
        if (min != null && root.val <= min.val) {
            return false;
        }
        // 判断是否符合右子树的值要求
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 更新左右子树的值要求
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

}