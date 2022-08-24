package linkedlist.mergeTwoSortedLists;

import linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 */
class Solution {

    /**
     * 遍历两个链表，比较节点的值，取值小的节点拼在后面。
     * 为了更方便的操作链表，使用一个哨兵节点 prehead和一个当前节点 prev。
     * 最后判断一个哪个链表不为空，全部拼接在新链表的最后面。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 哨兵节点
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            // prev 不断前进
            prev = prev.next;
        }

        if (list1 != null) {
            prev.next = list1;
        }
        if (list2 != null) {
            prev.next = list2;
        }

        return prehead.next;
    }

}