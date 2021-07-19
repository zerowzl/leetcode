package linkedlist.middleOfTheLinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class MiddleOfTheLinkedListTest {

    private MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();

    @Test
    public void middleNode() {
        ListNode listNode = solution.middleNode(new ListNode(1));
        assertEquals(1, listNode.val);
    }

    @Test
    public void middleNode_1() {
        ListNode listNode = solution.middleNode(new ListNode(1, new ListNode(2)));
        assertEquals(2, listNode.val);
    }

    @Test
    public void middleNode_2() {
        ListNode listNode = solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(3))));
        assertEquals(2, listNode.val);
    }

    @Test
    public void middleNode_3() {
        ListNode listNode = solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        assertEquals(3, listNode.val);
    }

}