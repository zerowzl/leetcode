package tree.binaryTreeRightSideView;

/* *****************************************************************************

199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 

示例: 
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

*******************************************************************************/

/* *****************************************************************************

题解：
广度优先

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/


import java.util.*;

/**
 * @author Dave Wang
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();

        // 层次遍历
        List<List<Integer>> levelOrder = levelOrder(root);
        for (List<Integer> list : levelOrder) {
            res.add(list.get(list.size() - 1));
        }

        return res;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }


}
