package tree.binaryTreeLevelOrderTraversal2;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class BinaryTreeLevelOrderTraversal2Test {

    private BinaryTreeLevelOrderTraversal2 solution = new BinaryTreeLevelOrderTraversal2();

    @Test
    public void levelOrderBottom() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        List<List<Integer>> res = solution.levelOrderBottom(root);
        System.out.println(res);
    }
}