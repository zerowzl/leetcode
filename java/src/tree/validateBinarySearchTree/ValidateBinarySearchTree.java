package tree.validateBinarySearchTree;

/* *****************************************************************************

98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。 

假设一个二叉搜索树具有如下特征： 
节点的左子树只包含小于当前节点的数。 
节点的右子树只包含大于当前节点的数。 
所有左子树和右子树自身必须也是二叉搜索树。 
 
示例 1: 
输入:
    2
   / \
  1   3
输出: true

示例 2: 
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class ValidateBinarySearchTree {

    /**
     * 一开始使用递归判断是否是二叉搜索树，但会出现局部是，整体不是的情况。[5,4,6,null,null,3,7]
     * 现修改为子节点的值是否在区间范围内。
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
}
