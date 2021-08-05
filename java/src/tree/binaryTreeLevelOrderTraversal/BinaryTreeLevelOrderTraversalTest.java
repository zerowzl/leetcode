package tree.binaryTreeLevelOrderTraversal;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class BinaryTreeLevelOrderTraversalTest {

    private BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

    @Test
    public void levelOrderBottom() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        List<List<Integer>> res = solution.levelOrder(root);
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            int[] ints = new int[2];
            for (int j = 0; j < list.size(); j++) {
                ints[j] = list.get(j);
            }
            arr[i] = ints;
        }

        Assert.assertArrayEquals(new int[][]{new int[]{1, 0}, new int[]{2, 3},
                new int[]{4, 5}}, arr);
    }
}