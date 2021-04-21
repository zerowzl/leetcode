package linkedlist;

/**
 * 2.两数相加
 *
 * @author davewang
 */
public class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode res = sentry;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = carry + num1 + num2;
            carry = sum / 10;
            sum = sum % 10;
            res.next = new ListNode(sum);
            res = res.next;
        }
        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        return sentry.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6));
        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.println(res);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
