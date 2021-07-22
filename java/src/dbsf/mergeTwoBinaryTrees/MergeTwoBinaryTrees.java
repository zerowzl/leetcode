package dbsf.mergeTwoBinaryTrees;

/* *****************************************************************************

617. 合并二叉树
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

示例 1:
输入:
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 
注意: 合并必须从两个树的根节点开始。

*******************************************************************************/

/* *****************************************************************************

题解：
深度优先搜索
1.都不为空, 进行合并并递归
2.有一个为空直接返回

复杂度分析：
时间复杂度：O(min(m,n)) 只有都不为空的时候才需要合并
空间复杂度：O(min(m,n))

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 3.有一个为空返回, 调用栈得到后直接赋值
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 1.都不为空, 合并
        TreeNode merged = new TreeNode(root1.val + root2.val);
        // 2.递归执行左子树和右子树
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
        // return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        TreeNode ans = new TreeNode();
        if (root1 != null) {
            if (root2 != null) {
                ans.val = root1.val + root2.val;
                ans.left = dfs(root1.left, root2.left);
                ans.right = dfs(root1.right, root2.right);
            } else {
                ans.val = root1.val;
                ans.left = dfs(root1.left, null);
                ans.right = dfs(root1.right, null);
            }
        } else {
            if (root2 != null) {
                ans.val = root2.val;
                ans.left = dfs(null, root2.left);
                ans.right = dfs(null, root2.right);
            } else {
                return null;
            }
        }
        return ans;
    }

}
