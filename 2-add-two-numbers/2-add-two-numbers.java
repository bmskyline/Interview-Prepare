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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int save = 0;
        ListNode start = new ListNode();
        ListNode res = start;
        while(l1 != null || l2 != null) {
            ListNode l = new ListNode();
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            if(x + y + save < 10) {
                l.val = x+ y+save;
                save = 0;
            } else {
                l.val = (x+ y+save) % 10;
                save = 1;
            }
            res.next = l;
            res = res.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(save == 1) {
            res.next = new ListNode(1);
        }
        return start.next;
    }
}