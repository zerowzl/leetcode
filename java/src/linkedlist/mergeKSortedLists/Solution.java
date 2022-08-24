package linkedlist.mergeKSortedLists;

import linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class Solution {

    /**
     * 优先队列（最小堆）
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 哨兵节点
        ListNode pervhead = new ListNode(-1);
        ListNode prev = pervhead;

        // 优先队列
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(lists.length,
                Comparator.comparingInt(o -> o.val));

        // 加入所有的头结点
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            // 从优先队列中取出最小的值
            ListNode listNode = pq.poll();
            prev.next = listNode;
            if (listNode.next != null) {
                pq.add(listNode.next);
            }
            // 移动当前节点
            prev = prev.next;
        }
        return pervhead.next;
    }
}