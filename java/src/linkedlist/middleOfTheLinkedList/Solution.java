package linkedlist.middleOfTheLinkedList;

import linkedlist.ListNode;

/**
 * 876. 链表的中间结点
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // 注意这里的判断，因为 fast 一次是跳2步，所有需要多判断一个 fast.next
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}