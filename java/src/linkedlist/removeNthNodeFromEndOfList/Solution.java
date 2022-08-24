package linkedlist.removeNthNodeFromEndOfList;

import linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 */
class Solution {
    /**
     * 快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prevhaed = new ListNode(-1);
        prevhaed.next = head;

        ListNode fast = prevhaed;
        ListNode slow = prevhaed;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return prevhaed.next;
    }

}