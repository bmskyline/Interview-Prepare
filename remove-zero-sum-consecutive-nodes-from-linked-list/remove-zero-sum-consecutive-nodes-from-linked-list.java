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
    public ListNode removeZeroSumSublists(ListNode head) {
        /*
        1 3 0 3 1
        
        1 2 4 -6 3
        1 3 7 1 8
        1 3
        0 1 2 4 - 4 -3 6
        0 1 3 7 3 0 6
        */
        Map<Integer, ListNode> map = new HashMap();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                map.get(sum).next = cur.next;
                return removeZeroSumSublists(dummy.next);
            } else {
                map.put(sum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
        
        /*
        Time complexity : O(n^2)
        Space complexity : O(n^2)
        */
    }
}