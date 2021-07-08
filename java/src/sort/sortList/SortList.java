package sort.sortList;

/* *****************************************************************************

148.排序链表

给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
进阶：
你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        // 求中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        // 分治
        ListNode mid = slow;
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(mid, tail);
        // 合并（归并）
        return merge(l1, l2);
    }

    /**
     * 自底而上进行局部排序，然后扩大范围，一直到全链表，排序算法使用归并排序。
     * 举例来说，源数据 5-4-6-3-2-1
     * 第一步：计算长度得 6
     * 第二步：设置初始排序长度 1
     * 第三步：分别对 5和4、6和3、2和1 进行排序，得到 4-5，3-6，1-2
     * 重复第二步，长度调整为 2，对 4-5 和 3-6、1-2 进行排序，得到 3-4-5-6，1-2
     * 重复第三步，长度调整为 4，对 3-4-5-6 和 1-2 进行排序，得到 1-2-3-4-5-6
     * <p>
     * 需要注意的：
     * 1）哨兵节点的使用
     * 2）每次进行归并排序的区间查找
     * 3）下次待排序的区间起点的确定
     */
    public ListNode sortListV2(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        ListNode sentry = new ListNode(0, head);
        // 子链表初始长度 1, 每次翻倍
        for (int subLength = 1; subLength < length; subLength = subLength * 2) {
            // 找到要合并的节点 -->  合并子链表
            // prev 前置(哨兵)节点
            ListNode prev = sentry, curr = sentry.next;
            while (curr != null) {
                // 左节点起始节点
                ListNode head1 = curr;
                // 本次要合并的范围
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 右节点起始节点
                ListNode head2 = curr.next;
                // --------------- start
                // 计算下次循环的起点
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // ---------------- end

                // 合并
                ListNode merged = merge(head1, head2);
                // 放置到区间排好序的节点后面
                prev.next = merged;
                // 更新到最后一个节点
                while (prev.next != null) {
                    prev = prev.next;
                }
                // 循环从 next 开始
                curr = next;
            }
        }

        return sentry.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
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
}
