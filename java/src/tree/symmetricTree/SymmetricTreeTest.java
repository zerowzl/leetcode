package tree.symmetricTree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void isSymmetricBFSSuccess() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        assertTrue(solution.isSymmetricBFS(root));
    }

    @Test
    public void isSymmetricBFSFail() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(solution.isSymmetricBFS(root));
    }

    @Test
    public void isSymmetricBFSNull() {
        assertTrue(solution.isSymmetricBFS(null));
    }

    @Test
    public void isSymmetricDFSSuccess() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        assertTrue(solution.isSymmetricDFS(root));
    }

    @Test
    public void isSymmetricDFSFail() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(solution.isSymmetricDFS(root));
    }

    @Test
    public void isSymmetricDFSNull() {
        assertTrue(solution.isSymmetricDFS(null));
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