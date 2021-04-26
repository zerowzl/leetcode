package linkedlist.removeNthFromEnd;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class RemoveNthFromEndTest {

    @Test
    public void test() {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res1 = removeNthFromEnd.removeNthFromEnd(listNode1, 1);
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res2 = removeNthFromEnd.removeNthFromEnd(listNode2, 2);
        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res3 = removeNthFromEnd.removeNthFromEnd(listNode3, 3);
        System.out.println("end");
    }

    @Test
    public void testV2() {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res1 = removeNthFromEnd.removeNthFromEndV2(listNode1, 1);
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res2 = removeNthFromEnd.removeNthFromEndV2(listNode2, 2);
        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode res3 = removeNthFromEnd.removeNthFromEndV2(listNode3, 3);
        System.out.println("end");
    }

}
