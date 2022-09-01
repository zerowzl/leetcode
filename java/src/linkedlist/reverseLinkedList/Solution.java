package linkedlist.reverseLinkedList;

import linkedlist.ListNode;

/**
 * 206. 反转链表
 */
class Solution {

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        // 跳出情况
        if (head == null || head.next == null) {
            return head;
        }

        // 递归处理
        ListNode newHead = reverseList(head.next);
        // 递归处理好了之后，当前节点应该怎么处理？
        // 放到下一个结点的后面（反转），断开连接（防止循环）
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}