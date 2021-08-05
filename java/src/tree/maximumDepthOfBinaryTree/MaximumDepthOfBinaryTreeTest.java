package tree.maximumDepthOfBinaryTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class MaximumDepthOfBinaryTreeTest {

    private MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

    @Test
    public void maxDepth() {
        assertEquals(0, solution.maxDepth(null));
        assertEquals(1, solution.maxDepth(new TreeNode(1)));
        assertEquals(2, solution.maxDepth(new TreeNode(1,
                new TreeNode(2), null)));
        assertEquals(2, solution.maxDepth(new TreeNode(1,
                new TreeNode(2), new TreeNode(3))));
        assertEquals(3, solution.maxDepth(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3))));
    }
}