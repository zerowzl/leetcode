package linkedlist;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author davewang
 */
public class IsPalindromeSolution {

    /**
     * 双指针，快指针走到头的时候，慢指针指向中点
     * 慢指针在走的时候，将前面部分进行反转
     * 最后比较慢指针后面的节点和前半部分反转的节点是否一致
     * 需要注意，如果节点是奇数，需要跳过中点指针
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode left = null;

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
            // 反转链表
            ListNode tem = left;
            left = slow;
            slow = slow.next;
            left.next = tem;
        }

        // 奇数，跳过第一个
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != left.val) {
                return false;
            }
            slow = slow.next;
            left = left.next;
        }
        // 后半部分走完了，如果前半部分没走完也是 false
        return left == null;
    }


    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(1);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(2, listNode2);
        ListNode listNode = new ListNode(1, listNode1);

        IsPalindromeSolution solution = new IsPalindromeSolution();
        System.out.println(solution.isPalindrome(listNode));
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
