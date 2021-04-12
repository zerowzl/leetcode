package linkedlist;

import java.net.CacheRequest;

/**
 * 反转一个单链表。
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author davewang
 */
public class ReverseLinkedListSolution {

    /**
     * 使用两个指针，当前指针和前置指针，每次遍历的时候将当前指针赋值给前置指针
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 前置指针
        ListNode prev = null;
        // 当前指针
        ListNode cur = head;
        // 循环
        while (cur != null) {
            // 先将上次的前置指针的节点使用临时变量记录下
            ListNode tem = prev;
            // 将当前节点赋值的前置节点
            prev = cur;
            // 将当前节点的下个节点赋值给当前节点用于下次遍历, 并且需要在上次链表调转(也就是下一步要做的事)前
            cur = cur.next;
            // 将上次前置节点记录下的节点赋值给当前这次前置节点的next, 其实就是反转了链表
            prev.next = tem;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode listNode2 = new ListNode(3);
        ListNode listNode1 = new ListNode(2, listNode2);
        ListNode listNode = new ListNode(1, listNode1);

        ReverseLinkedListSolution solution = new ReverseLinkedListSolution();
        ListNode res = solution.reverseList(listNode);
        System.out.println(res);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
