package tree.minimumDepthOfBinaryTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class MinimumDepthOfBinaryTreeTest {

    private MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();

    @Test
    public void minDepth() {
        assertEquals(0, solution.minDepth(null));
        assertEquals(1, solution.minDepth(new TreeNode(1)));
        assertEquals(2, solution.minDepth(new TreeNode(1, new TreeNode(2), null)));
        assertEquals(2, solution.minDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        assertEquals(2, solution.minDepth(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))));
        assertEquals(3, solution.minDepth(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))));
    }
}