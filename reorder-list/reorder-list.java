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
    public void reorderList(ListNode head) {
        //find mid node
        //revert after mid
        //merge
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        slow = reverse(slow);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            ListNode temp2 = slow.next;
            cur.next = slow;
            slow.next = temp;
            cur = temp;
            slow = temp2;
        }
    }
    
    ListNode reverse(ListNode head) {
      ListNode prev = null, curr = head, next = null;
      
      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      
      return prev;
    }
}