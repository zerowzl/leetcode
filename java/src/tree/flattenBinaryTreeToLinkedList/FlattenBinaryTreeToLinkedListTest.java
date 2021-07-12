package tree.flattenBinaryTreeToLinkedList;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class FlattenBinaryTreeToLinkedListTest {

    private FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();

    @Test
    public void flatten() {
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6));
        solution.flatten(root);
        System.out.println(root);
    }
}