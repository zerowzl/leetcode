package binarytree.constructBinaryTreeFromPreorderAndInorderTraversal;

import binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
class Solution {

    // 中序遍历值和索引的映射，方便在使用前序遍历数组快速定位元素在中序遍历的位置
    private Map<Integer, Integer> inorderMap = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }

        // 前序遍历序列的第一个就是 root
        int rootVal = preorder[preStart];
        // root 在中序遍历中的索引
        Integer inorderRootIndex = inorderMap.get(rootVal);
        // inorderRootIndex 左边的是左子树；inorderRootIndex 右边的是右子树
        // 左子树的元素长度
        int leftSize = inorderRootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart);
        root.right = build(preorder, preStart + 1 + leftSize, preEnd, inorderRootIndex + 1);
        return root;
    }
}