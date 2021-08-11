package linkedlist.removeDuplicatesFromSortedList2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class RemoveDuplicatesFromSortedList2Test {

    private RemoveDuplicatesFromSortedList2 solution = new RemoveDuplicatesFromSortedList2();

    @Test
    public void deleteDuplicates() {
        ListNode root = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(3, new ListNode(4,
                        new ListNode(4, new ListNode(5)))))));
        ListNode listNode = solution.deleteDuplicates(root);
        int[] ans = new int[]{1, 2, 5};
        int[] res = new int[3];
        int i = 0;
        while (listNode != null) {
            res[i++] = listNode.val;
            listNode = listNode.next;
        }
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void deleteDuplicates_2() {
        ListNode root = new ListNode(1, new ListNode(1,
                new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode listNode = solution.deleteDuplicates(root);
        int[] ans = new int[]{2, 3};
        int[] res = new int[2];
        int i = 0;
        while (listNode != null) {
            res[i++] = listNode.val;
            listNode = listNode.next;
        }
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void deleteDuplicates_3() {
        ListNode root = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(3, new ListNode(3)))));
        ListNode listNode = solution.deleteDuplicates(root);
        int[] ans = new int[]{1, 2};
        int[] res = new int[2];
        int i = 0;
        while (listNode != null) {
            res[i++] = listNode.val;
            listNode = listNode.next;
        }
        Assert.assertArrayEquals(ans, res);
    }
}