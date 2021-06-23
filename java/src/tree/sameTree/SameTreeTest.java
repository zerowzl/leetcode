package tree.sameTree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class SameTreeTest {

    private SameTree solution = new SameTree();

    @Test
    public void isSameTree() {
        boolean sameTree = solution.isSameTree(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        assertTrue(sameTree);

        boolean sameTree2 = solution.isSameTree(
                new TreeNode(1, new TreeNode(1), null),
                new TreeNode(1, null, new TreeNode(1)));
        assertFalse(sameTree2);
    }
}