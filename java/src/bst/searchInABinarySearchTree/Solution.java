package bst.searchInABinarySearchTree;

import binarytree.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}