package tree.validateBinarySearchTree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class ValidateBinarySearchTreeTest {

    private ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

    @Test
    public void isValidBST() {
        assertTrue(solution.isValidBST(null));
        assertTrue(solution.isValidBST(new TreeNode(2)));
        assertTrue(solution.isValidBST(new TreeNode(2, null, null)));
        assertTrue(solution.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        assertFalse(solution.isValidBST(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        assertTrue(solution.isValidBST(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)))));
        assertTrue(solution.isValidBST(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(7, new TreeNode(6), null))));
        assertFalse(solution.isValidBST(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(7, new TreeNode(8), null))));
        assertTrue(solution.isValidBST(new TreeNode(Integer.MAX_VALUE)));
        assertTrue(solution.isValidBST(new TreeNode(Integer.MIN_VALUE)));
    }
}