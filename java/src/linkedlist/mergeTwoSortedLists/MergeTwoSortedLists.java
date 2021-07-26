package linkedlist.mergeTwoSortedLists;

/* *****************************************************************************

21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

示例 2：
输入：l1 = [], l2 = []
输出：[]

示例 3：
输入：l1 = [], l2 = [0]
输出：[0]
 
提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列

*******************************************************************************/

/* *****************************************************************************

题解：
遍历的方式，先定义一个哨兵节点，方便返回。再定义一个前置节点，默认和哨兵节点一样都为-1。
然后只要两个链表都不为空，就比较哪个的值小，小的那个赋值给前置节点的next，并更新下一个，每次循环最后需要更新前置节点。
最后判断空的链表，加到前置节点最后并返回哨兵节点的next节点。

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(m + n)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class MergeTwoSortedLists {

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

    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

}
