package tree.invertBinaryTree;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class InvertBinaryTreeTest {

    private InvertBinaryTree solution = new InvertBinaryTree();

    @Test
    public void invertTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(7, new TreeNode(8), new TreeNode(9)));
        TreeNode res = solution.invertTree(root);
        System.out.println(res);
    }
}