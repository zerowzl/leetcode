package linkedlist.mergeKSortedLists;

import java.util.PriorityQueue;

/* *****************************************************************************

23. 合并K个升序链表
给你一个链表数组，每个链表都已经按升序排列。 
请你将所有链表合并到一个升序链表中，返回合并后的链表。

示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

示例 2：
输入：lists = []
输出：[]
 
示例 3：
输入：lists = [[]]
输出：[]
 
提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4

*******************************************************************************/

/* *****************************************************************************

题解：
1. 多次的合并两个升序链表
2. 优先队列

复杂度分析：
时间复杂度：
空间复杂度：

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class MergeKSortedLists {

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


}
