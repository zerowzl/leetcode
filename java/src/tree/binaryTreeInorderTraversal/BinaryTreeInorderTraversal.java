package tree.binaryTreeInorderTraversal;

/* *****************************************************************************

94. 二叉树的中序遍历
中序遍历的顺序: 左 --> 当前 --> 右

*******************************************************************************/

/* *****************************************************************************

题解：
递归

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalCore(root, res);
        return res;
    }

    private void inorderTraversalCore(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 左
        if (root.left != null) {
            inorderTraversalCore(root.left, res);
        }

        // 当前
        res.add(root.val);

        // 右
        if (root.right != null) {
            inorderTraversalCore(root.right, res);
        }
    }

}
