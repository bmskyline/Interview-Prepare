/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null && cur.next != null) {
            if (cur.val < cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                if (pre == null)
                    head = cur;
                else {
                    pre.next = cur;
                }
                  
            }
        }
        return head;
    }
}