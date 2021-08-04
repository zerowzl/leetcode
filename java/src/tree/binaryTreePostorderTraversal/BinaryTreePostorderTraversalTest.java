package tree.binaryTreePostorderTraversal;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class BinaryTreePostorderTraversalTest {

    private BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();

    @Test
    public void postorderTraversalDFS() {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        List<Integer> res = solution.postorderTraversalDFS(treeNode);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        assertArrayEquals(new int[]{1, 3, 2, 5, 7, 6, 4}, arr);
    }
}