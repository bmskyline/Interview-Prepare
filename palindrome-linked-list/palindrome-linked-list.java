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
    public boolean isPalindrome(ListNode head) {
        /*
        spit linklist into 2 part
        reverse the second path 
        compare two linklist
        */
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return compare(head, reverse(slow));
    }
    
    boolean compare(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val)
                return false;
            a = a.next;
            b = b.next;
        }
        return (a == null && b == null) || ( a== null && b.next == null);
    }
    
    ListNode reverse(ListNode head) {
        if (head.next == null)
            return head;
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}