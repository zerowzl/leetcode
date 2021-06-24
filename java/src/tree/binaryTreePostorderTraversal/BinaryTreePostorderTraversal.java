package tree.binaryTreePostorderTraversal;

/* *****************************************************************************

144. 二叉树的后序遍历

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            dfs(root.left, res);
        }

        if (root.right != null) {
            dfs(root.right, res);
        }
        res.add(root.val);
    }
}
