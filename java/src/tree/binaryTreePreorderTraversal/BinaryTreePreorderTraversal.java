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

    public List<Integer> preorderTraversalDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}
