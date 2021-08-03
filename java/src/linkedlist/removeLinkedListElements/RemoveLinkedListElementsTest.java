package linkedlist.removeLinkedListElements;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class RemoveLinkedListElementsTest {

    private RemoveLinkedListElements solution = new RemoveLinkedListElements();

    @Test
    public void removeElements() {
        // ListNode head = new ListNode();
        ListNode res = solution.removeElements(null, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    @Test
    public void removeElements1() {
        ListNode head = new ListNode(0);
        ListNode res = solution.removeElements(head, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    @Test
    public void removeElements2() {
        ListNode head = new ListNode(1);
        ListNode res = solution.removeElements(head, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    @Test
    public void removeElements3() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1,
                new ListNode(2, new ListNode(3)))));
        ListNode res = solution.removeElements(head, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    @Test
    public void removeElements4() {
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(6, new ListNode(3,
                        new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode res = solution.removeElements(head, 6);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


}