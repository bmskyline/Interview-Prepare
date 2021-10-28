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
    public ListNode partition(ListNode head, int x) {
        /*
        1 -> 2 -> 2 -> 4
        4 -> 3 -> 5
        */
        ListNode first = null;
        ListNode second = null;
        ListNode cur = head;
        ListNode start = new ListNode();
        ListNode between = new ListNode();;
        while (cur != null) {
            if (cur.val < x) {
                if (first == null) {
                    first = cur;
                    start.next = first;
                } else {
                    first.next = cur;
                    first = first.next;
                }
            } else {
                if (second == null) {
                    second = cur;
                    between.next = second;
                } else {
                    second.next = cur;
                    second = second.next;
                }
            }
            cur = cur.next;
        }
        if (first == null || second == null)
            return head;
        second.next = null;
        first.next = between.next;
        return start.next;
    }
}