package linkedlist;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 *
 * @author davewang
 */
public class LinkedListCycleIiSolution {

    /**
     * 快慢指针
     * 假定有环，head 到环入口节点的距离定义为 a，环周长定义为 b
     * 快慢指针，slow 步长1，fast 步长2，如果相遇，首先 fast 和 slow 都走了 a 的距离，然后 fast 比 slow 多走了 n 的 b，slow 走了 nb 长
     * 我们知道，从 head 走了 a 后，后面无论走了多少圈都会回到环的入口，也就是 a+nb
     * 那么，前面我们知道 slow 走了 nb，那再走 a 的距离就会回到环的入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            // 慢指针走一步
            slow = slow.next;
            if (fast.next != null) {
                // 快指针走两步
                fast = fast.next.next;
            }
            // 走到头了，没有环
            else {
                return null;
            }

            // 遇到了，有环
            if (fast == slow) {
                // 从头开始走 a 步
                ListNode tem = head;
                while (tem != slow) {
                    tem = tem.next;
                    slow = slow.next;
                }

                return tem;
            }
        }

        return null;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
