package linkedlist.mergeTwoSortedLists;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class MergeTwoSortedListsTest {

    private MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @Test
    public void mergeTwoListsRecursion() {
        ListNode ans = solution.mergeTwoListsRecursion(null, null);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    @Test
    public void mergeTwoListsRecursion_1() {
        ListNode ans = solution.mergeTwoListsRecursion(null, new ListNode(1));
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    @Test
    public void mergeTwoListsRecursion_2() {
        ListNode ans = solution.mergeTwoListsRecursion(new ListNode(2), new ListNode(1));
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    @Test
    public void mergeTwoListsRecursion_3() {
        ListNode ans = solution.mergeTwoListsRecursion(new ListNode(1, new ListNode(3, new ListNode(5))),
                new ListNode(2, new ListNode(4, new ListNode(6))));
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}