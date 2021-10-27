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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode one = mergeSort(pre.next);
        pre.next = null;
        ListNode two = mergeSort(head);
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        while (one != null || two != null) {
            if (one != null && two != null) {
                if (one.val > two.val) {
                    dummy.next = two;
                    dummy = dummy.next;
                    two = two.next;
                } else {
                    dummy.next = one;
                    dummy = dummy.next;
                    one = one.next;
                }
            } else if (one != null) {
                dummy.next = one;
                dummy = dummy.next;
                one = one.next;
            } else {
                dummy.next = two;
                dummy = dummy.next;
                two = two.next;
            }
        }
        return newHead.next;
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(1)
    */
}