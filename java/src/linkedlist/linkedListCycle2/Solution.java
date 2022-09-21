package linkedlist.linkedListCycle2;

import linkedlist.ListNode;

/**
 * 142. 环形链表 II
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 快走2步，慢走1步，相等就跳出
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // fast 走到最后了，说明没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 有环的情况，slow 走了 k 步， fast 走了 2k 步，fast 多走的 k 步 就是环长度的倍数。
        // 相遇点和环的入口点相距 m 步，那么从头结点到环的入口点就需要走 k - m 步；
        // 并且从相遇点走 k - m 步也可以到达环的入口点。
        // 那么让其中一个指针回到头结点，然后两个指针一起走（k-m）步，相遇了就是环的入口点。
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}