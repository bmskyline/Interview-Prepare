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
    ListNode node = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        } else if (left > 1){
            ListNode newHead = head;
            newHead.next = reverseBetween(head.next, left-1, right-1);
            return newHead;
        } else {
            ListNode cur = reverseBetween(head.next, left, right-1);
            ListNode nextnext = head.next.next;
            head.next.next = head;
            head.next = nextnext;
            return cur;
        }
    }
}