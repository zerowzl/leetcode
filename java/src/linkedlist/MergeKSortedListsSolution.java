package linkedlist;

import java.util.PriorityQueue;

/**
 * Merge k Sorted Lists（合并 k 个排序链表）
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author davewang
 */
public class MergeKSortedListsSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            if (i == 0) {
                res = lists[0];
                continue;
            }

            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 哨兵节点，方便最后返回
        ListNode preHead = new ListNode(-1);
        // 前置节点
        ListNode prev = preHead;
        // 只有都不为空就一直循环
        while (l1 != null && l2 != null) {
            // 比较那个小，就将那个赋值给前置指针的next，并取下一个继续
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // 需要更新一下前置节点
            prev = prev.next;
        }
        // 最后如果有一个为空，就添加到最后
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * 优先队列，先将所有节点放入一个优先队列（根据 val 排序），然后遍历这个优先队列就好
     */
    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNodeCom> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(new ListNodeCom(list));
            }
        }

        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (!queue.isEmpty()) {
            ListNodeCom listNodeCom = queue.poll();
            cur.next = listNodeCom.listNode;
            cur = cur.next;
            if (listNodeCom.listNode.next != null) {
                queue.offer(new ListNodeCom(listNodeCom.listNode.next));
            }
        }

        return res.next;
    }

    static class ListNodeCom implements Comparable<ListNodeCom> {
        ListNode listNode;

        public ListNodeCom(ListNode listNode) {
            this.listNode = listNode;
        }

        @Override
        public int compareTo(ListNodeCom o) {
            return this.listNode.val - o.listNode.val;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(6, new ListNode(6)));

        MergeKSortedListsSolution solution = new MergeKSortedListsSolution();
        ListNode res = solution.mergeKListsV2(new ListNode[]{l1, l2});
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
