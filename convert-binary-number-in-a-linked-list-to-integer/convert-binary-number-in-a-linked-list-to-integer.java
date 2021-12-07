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
    public int getDecimalValue(ListNode head) {
        /*
        1 * 2 +0 = 2
        2x2 +1
        
        11010
         3613 26
        */
        int i = head.val;
        head = head.next;
        while (head != null) {
            i = i * 2 + head.val;
            head = head.next;
        }
        return i;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}