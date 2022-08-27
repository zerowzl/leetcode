package linkedlist.removeDuplicatesFromSortedList;

import linkedlist.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * Definition for singly-linked list.
 */
class Solution {
    /**
     * 双指针：
     * 使用快慢指针 `fast`  和 `slow`，每走一步就判断一个和 `slow` 的值，如果不一样，
     * 就将 `slow` 的`next` 设置为 `fast`。
     * 移动 `fast`，最后需要注意尾结点可能还有重复的元素需要断开。
     * 因为在原链表上操作，直接返回 `head` 就可以。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            // 在 slow 后面拼接上不同值的结点
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        // 后面可能还有重复的元素
        slow.next = null;
        return head;
    }
}