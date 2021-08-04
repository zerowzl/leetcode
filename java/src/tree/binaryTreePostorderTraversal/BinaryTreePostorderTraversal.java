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

    public List<Integer> postorderTraversalDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}
