package linkedlist.partitionList;

import linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 */
class Solution {

    /**
     * 首先创建两个链表，less 和 ge ，遍历原链表，小于的放到 less 中，大于等于的放到 ge 中。
     * 最后将 less 和 ge 拼接在一起。这里为了操作方便需要使用一个 prevhead 哨兵节点。
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1);
        ListNode less = lessHead;
        ListNode geHead = new ListNode(-1);
        ListNode ge = geHead;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                ge.next = head;
                ge = ge.next;
            }
            // 断开head和next节点
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }

        less.next = geHead.next;
        return lessHead.next;
    }
}