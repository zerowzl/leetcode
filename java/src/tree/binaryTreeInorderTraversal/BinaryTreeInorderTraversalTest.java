package tree.binaryTreeInorderTraversal;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class BinaryTreeInorderTraversalTest {

    private BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

    @Test
    public void inorderTraversal() {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        List<Integer> res = solution.inorderTraversal(treeNode);
        System.out.println(res);

        TreeNode treeNode2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                null);
        List<Integer> res2 = solution.inorderTraversal(treeNode2);
        System.out.println(res2);

        TreeNode treeNode3 = new TreeNode(4,
                null,
                new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        List<Integer> res3 = solution.inorderTraversal(treeNode3);
        System.out.println(res3);
    }


}