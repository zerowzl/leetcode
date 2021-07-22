package dbsf.populatingNextRightPointersInEachNode;

/* *****************************************************************************

116. 填充每个节点的下一个右侧节点指针
给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
} 

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。

进阶：
 你只能使用常量级额外空间。
 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 

示例：
输入：root = [1,2,3,4,5,6,7]
输出：[1,#,2,3,#,4,5,6,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。

提示：
 树中节点的数量少于 4096
 -1000 <= node.val <= 1000

*******************************************************************************/

/* *****************************************************************************

题解：
广度优先算法

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

*******************************************************************************/

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dave Wang
 */
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 遍历到的元素个数
        int count = 0;
        // 当前层, 从0开始
        int level = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }

            count++;
            level++;
            // 因为是满二叉树 可以用 [ (2 << level) - 1 ] 来判断是否是当前层最后一个元素
            if (count != (2 << level) - 1) {
                poll.next = queue.peek();
                // 上面加了不是最后一个需要减回去
                level--;
            }
        }

        return root;
    }


    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode solution = new PopulatingNextRightPointersInEachNode();
        // 1,2,3,4,5,6,7
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        Node connect = solution.connect(root);
        System.out.println(connect);
    }

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }

}
