package tree.symmetricTree;

/* *****************************************************************************

101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3

进阶：
你可以运用递归和迭代两种方法解决这个问题吗？

*******************************************************************************/

import java.util.*;

/**
 * @author Dave Wang
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return bfs(root);
    }

    private boolean bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode != null) {
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    } else {
                        queue.offer(null);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    } else {
                        queue.offer(null);
                    }
                    list.add(currentNode.val);
                } else {
                    list.add(null);
                }
            }

            int p = 0;
            int q = list.size() - 1;
            while (p < q) {
                Integer pi = list.get(p);
                Integer qi = list.get(q);
                if (!Objects.equals(pi, qi)) {
                    return false;
                }
                p++;
                q--;
            }
        }

        return true;
    }


    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}