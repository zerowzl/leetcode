package linkedlist.reverseLinkedList2;

import linkedlist.ListNode;

/**
 * 92. 反转链表 II
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 就是反转前几个结点
        if (left == 1) {
            return reverseN(head, right);
        }
        // 将下一个结点后的链表作为新的链表递归处理,目的是为了到达 left 是头结点
        // 那么之前的就是不需要反转的,直接在拼接在后面就可以
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }


    // 反转和不需要反转的结点的边界结点
    private ListNode nextParagraph = null;

    public ListNode reverseN(ListNode head, int n) {
        // 退出条件
        if (n == 1) {
            nextParagraph = head.next;
            return head;
        }
        // 递归处理下一个结点
        ListNode next = reverseN(head.next, n - 1);
        // 反转当前结点和下一个结点
        head.next.next = head;
        // 拼接上不需要反转的结点
        head.next = nextParagraph;
        return next;
    }
}