/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow,fast;
        slow = head;
        fast = head.next;
        while(true) {
            if(fast == null) {
                return false;
            } else if(slow == fast) {
                return true;
            }
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
            else
                return false;
        }
    }
}