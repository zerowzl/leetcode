package tree.twoSumIvInputIsABst;

/* *****************************************************************************

653. 两数之和 IV - 输入 BST
给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

示例 1：
输入: root = [5,3,6,2,4,null,7], k = 9
输出: true

示例 2：
输入: root = [5,3,6,2,4,null,7], k = 28
输出: false

示例 3：
输入: root = [2,1,3], k = 4
输出: true

示例 4：
输入: root = [2,1,3], k = 1
输出: false

示例 5：
输入: root = [2,1,3], k = 3
输出: true


提示:
二叉树的节点个数的范围是  [1, 104].
-104 <= Node.val <= 104
root 为二叉搜索树
-105 <= k <= 105

*******************************************************************************/

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}