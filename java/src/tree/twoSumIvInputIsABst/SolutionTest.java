package tree.twoSumIvInputIsABst;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void findTarget() {
        assertTrue(solution.findTarget(new TreeNode(1, new TreeNode(1), null), 2));
    }

    @Test
    public void findTarget2() {
        assertTrue(solution.findTarget(new TreeNode(5,
                        new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                        new TreeNode(6, null, new TreeNode(7))),
                9));
    }

    @Test
    public void findTarget3() {
        assertTrue(solution.findTarget(new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                4));
    }
}