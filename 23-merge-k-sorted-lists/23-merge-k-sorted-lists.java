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
    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        int interval = 1;
        while (interval < n) {
            for (int i = 0; i < n - interval; i += 2 * interval)
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            interval *= 2;
        }
        return n > 0 ? lists[0] : null;
    }
    
    ListNode merge2Lists(ListNode n1, ListNode n2) {
        if (n2 == null)
            return n1;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (n1 != null && n2!= null) {
            if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if (n1 != null) {
            cur.next = n1;
        }
        if (n2 != null) {
            cur.next = n2;
        }
        return head.next;
    }
}