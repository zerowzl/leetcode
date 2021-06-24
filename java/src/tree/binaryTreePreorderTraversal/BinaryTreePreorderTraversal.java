package tree.binaryTreePreorderTraversal;

/* *****************************************************************************

144. 二叉树的前序遍历

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        if (root.left != null) {
            dfs(root.left, res);
        }

        if (root.right != null) {
            dfs(root.right, res);
        }
    }

}
