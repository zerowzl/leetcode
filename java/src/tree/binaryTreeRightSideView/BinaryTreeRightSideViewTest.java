package tree.binaryTreeRightSideView;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class BinaryTreeRightSideViewTest {

    @Test
    public void rightSideView() {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(5, null, null), null),
                new TreeNode(3, null, new TreeNode(4, null, null)));
        List<Integer> res = solution.rightSideView(root);
        System.out.println(res);
    }
}