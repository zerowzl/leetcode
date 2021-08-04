package tree.binaryTreeInorderTraversal;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 */
public class BinaryTreeInorderTraversalTest {

    private BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

    @Test
    public void inorderTraversalDFS() {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        List<Integer> res = solution.inorderTraversalDFS(treeNode);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, arr);
    }

    @Test
    public void inorderTraversalDFS_1() {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                null);
        List<Integer> res = solution.inorderTraversalDFS(treeNode);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr);
    }

    @Test
    public void inorderTraversalDFS_2() {
        TreeNode treeNode = new TreeNode(4,
                null,
                new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        List<Integer> res = solution.inorderTraversalDFS(treeNode);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        assertArrayEquals(new int[]{4, 5, 6, 7}, arr);
    }

}