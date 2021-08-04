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

    public List<Integer> inorderTraversalDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }


}
