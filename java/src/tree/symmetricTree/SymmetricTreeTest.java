package tree.symmetricTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class SymmetricTreeTest {

    private SymmetricTree solution = new SymmetricTree();

    @Test
    public void isSymmetricSuccess() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        assertTrue(solution.isSymmetric(root));
    }

    @Test
    public void isSymmetricFail() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(solution.isSymmetric(root));
    }

    @Test
    public void isSymmetricNull() {
        assertTrue(solution.isSymmetric(null));
    }

    @Test
    public void isSymmetric2Success() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        assertTrue(solution.isSymmetric2(root));
    }

    @Test
    public void isSymmetric2Fail() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(solution.isSymmetric2(root));
    }

    @Test
    public void isSymmetric2Null() {
        assertTrue(solution.isSymmetric2(null));
    }

}