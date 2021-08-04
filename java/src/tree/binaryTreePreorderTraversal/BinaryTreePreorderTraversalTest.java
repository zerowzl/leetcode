package tree.binaryTreePreorderTraversal;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class BinaryTreePreorderTraversalTest {

    private BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();

    @Test
    public void preorderTraversalDFS() {
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        TreeNode root = new TreeNode(1, null, right);
        List<Integer> ans = solution.preorderTraversalDFS(root);
        int[] ints = new int[3];
        for (int i = 0; i < ans.size(); i++) {
            ints[i] = ans.get(i);
        }
        Assert.assertArrayEquals(new int[]{1, 2, 3}, ints);
    }
}