package linkedlist.removeNthFromEnd;

/* *****************************************************************************

19. 删除链表的倒数第 N 个节点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
进阶：你能尝试使用一趟扫描实现吗？

示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]
 
示例 3：
输入：head = [1,2], n = 1
输出：[1]

提示：
链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz 

*******************************************************************************/

/* *****************************************************************************

题解：
首先想到的方法是先遍历一次获取到链表的长度，然后使用（长度 - 要删除的节点的倒数）得到要删除节点的正向位数，再遍历一次删除。
不过，需要扫描两次链表，不满足进阶的要求。

复杂度分析：
时间复杂度：两次遍历，O(n)
空间复杂度：不需要额外存储，O(1)

题解2：
使用快慢指针，快指针初始指向 head，慢指针初始指向哨兵节点，
快指针先走 n 个节点，当快指针达到尾结点的时候，慢指针的 next 节点就是要删除的节点。

复杂度分析：
时间复杂度：一次遍历，O(n)
空间复杂度：不需要额外存储，O(1)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        // 计算链表长度
        int length = 0;
        ListNode tem = head;
        while (tem != null) {
            tem = tem.next;
            length++;
        }

        // 计算要删除节点的正向位数
        int index = length - n;
        if (index < 0 || n > length) {
            return head;
        }

        // 哨兵节点和要删除节点的前置节点
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;

        for (int i = 0; i <= index; i++) {
            // 是要删除的节点，更新前置的 next 节点为要删除节点的 next 节点，并退出循环
            if (i == index) {
                pre.next = head.next;
                break;
            } else {
                // 更新前置节点的 next 节点为当前节点
                pre.next = head;
                pre = pre.next;
            }
            // 更新 head 节点为 next 节点，以遍历
            head = head.next;
        }

        // 返回哨兵节点的 next 节点
        return res.next;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = res;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return res.next;
    }

}
