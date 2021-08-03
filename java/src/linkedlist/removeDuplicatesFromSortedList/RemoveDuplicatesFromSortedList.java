package linkedlist.removeDuplicatesFromSortedList;

/* *****************************************************************************
83. 删除排序链表中的重复元素
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
返回同样按升序排列的结果链表。

示例 1：
输入：head = [1,1,2]
输出：[1,2]

示例 2：
输入：head = [1,1,2,3,3]
输出：[1,2,3]

提示：
 链表中节点数目在范围 [0, 300] 内
 -100 <= Node.val <= 100 
 题目数据保证链表已经按升序排列 

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(0, head);
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return prev.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        solution.deleteDuplicates(new ListNode(1));
        solution.deleteDuplicates(new ListNode(1, new ListNode(1)));
        solution.deleteDuplicates(new ListNode(1, new ListNode(1,
                new ListNode(1))));
        solution.deleteDuplicates(new ListNode(1, new ListNode(2,
                new ListNode(2, new ListNode(2, new ListNode(3))))));

    }
}
