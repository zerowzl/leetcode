package tree.flattenBinaryTreeToLinkedList;

/* *****************************************************************************

114.二叉树展开为链表

给你二叉树的根结点 root ，请你将它展开为一个单链表： 
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 
示例 1：
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
 
示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [0]
输出：[0]
 
提示：
树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100

进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？

*******************************************************************************/

/* *****************************************************************************

题解：
使用前序遍历得到所有的节点，然后按序设置

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        preorderTraversal(root, res);

        TreeNode prev = new TreeNode(0, null, null);
        for (TreeNode node : res) {
            if (node != null) {
                node.left = null;
                node.right = null;
                prev.right = node;
                prev = prev.right;
            }
        }
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            res.add(null);
            return;
        }

        res.add(root);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}
