package linkedlist.linkedListCycle;

import linkedlist.ListNode;

/**
 * 141. 环形链表
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 快走2步，慢走1步，相等就返回
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}