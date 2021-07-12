package sort.sortList;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class SortListTest {

    private SortList solution = new SortList();

    @Test
    public void sortList() {
        ListNode root = new ListNode(5, new ListNode(3, new ListNode(2,
                new ListNode(4, new ListNode(1, new ListNode(6))))));
        ListNode res = solution.sortList(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    @Test
    public void sortListV2() {
        ListNode root = new ListNode(5, new ListNode(3, new ListNode(2,
                new ListNode(4, new ListNode(1, new ListNode(6))))));
        ListNode res = solution.sortListV2(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}