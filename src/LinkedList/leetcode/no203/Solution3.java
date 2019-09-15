package LinkedList.leetcode.no203;

/**
 * @author Boli Tao
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode result = removeElements(head.next, val);
        if (head.val == val) {
            return result;
        } else {
            head.next = result;
            return head;
        }
    }
}
