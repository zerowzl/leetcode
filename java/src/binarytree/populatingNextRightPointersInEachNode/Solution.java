package binarytree.populatingNextRightPointersInEachNode;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return null;
    }

    public void traverse(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        // 将右子节点赋值到左子节点的next
        root1.next = root2;
        // 处理左节点的左右子节点
        traverse(root1.left, root1.right);
        // 处理右节点的左右子节点
        traverse(root2.left, root2.right);
        // 处理左子树的右节点和右子树的左节点
        traverse(root1.right, root2.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}