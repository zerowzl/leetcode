package tree.pathSum;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void hasPathSum() {
        TreeNode root = new TreeNode(1);
        assertTrue(solution.hasPathSum(root, 1));
    }

    @Test
    public void hasPathSum1() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(solution.hasPathSum(root, 1));
    }

    @Test
    public void hasPathSum2() {
        assertFalse(solution.hasPathSum(null, 2));
    }

    @Test
    public void hasPathSum3() {
        TreeNode root = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        assertTrue(solution.hasPathSum(root, 2));
    }

    @Test
    public void hasPathSum4() {
        TreeNode root = new TreeNode(1, new TreeNode(3), new TreeNode(1));
        assertTrue(solution.hasPathSum(root, 2));
    }

    @Test
    public void hasPathSum5() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        assertTrue(solution.hasPathSum(root, 22));
    }
}