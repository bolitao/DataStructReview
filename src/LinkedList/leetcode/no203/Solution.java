package LinkedList.leetcode.no203;

/**
 * 方法一：使用虚拟头节点
 *
 * @author Boli Tao
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        for (ListNode tmp = dummyHead; tmp.next != null; ) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return dummyHead.next;
    }
}
