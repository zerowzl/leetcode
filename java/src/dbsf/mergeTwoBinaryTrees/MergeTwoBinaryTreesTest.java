package dbsf.mergeTwoBinaryTrees;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class MergeTwoBinaryTreesTest {

    MergeTwoBinaryTrees solution = new MergeTwoBinaryTrees();

    @Test
    public void mergeTrees() {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(11)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode treeNode = solution.mergeTrees(root1, root2);
        System.out.println(treeNode);
    }
}