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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode save = head;
        ListNode cur = head;
        int length = 0;
        while(save != null) {
            length++;
            save = save.next;
        }
        if(length == 1 || length == 0)
            return head;
        k = k % length;
        save = head;
        cur = head;
        int j = 0;
        while (j < k) {
            cur = cur.next;
            j++;
        }
        while (cur.next != null) {
            save = save.next;
            cur = cur.next;
        }
        cur.next = head;
        head = save.next;
        save.next = null;
        return head;
    }
}