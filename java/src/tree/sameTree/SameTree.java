package tree.sameTree;

/* *****************************************************************************

100. 相同的树
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1：
输入：p = [1,2,3], q = [1,2,3]
输出：true

示例 2：
输入：p = [1,2], q = [1,null,2]
输出：false

示例 3：
输入：p = [1,2,1], q = [1,1,2]
输出：false

提示：
两棵树上的节点数目都在范围 [0, 100] 内
-104 <= Node.val <= 104

*******************************************************************************/

/* *****************************************************************************

题解：
深度优先算法，注意需要使用前序遍历。

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/


import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Wang
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        List<Integer> ps = new ArrayList<>();
        List<Integer> qs = new ArrayList<>();
        dfs(p, ps);
        dfs(q, qs);

        return ps.equals(qs);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left != null) {
            dfs(root.left, list);
        } else {
            list.add(null);
        }

        if (root.right != null) {
            dfs(root.right, list);
        } else {
            list.add(null);
        }
    }

}