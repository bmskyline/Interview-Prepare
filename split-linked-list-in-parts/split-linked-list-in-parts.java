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
    public ListNode[] splitListToParts(ListNode head, int k) {
        /*
        1 2 3 4 5 6 7 9 8 10
        count number of node
        number / k
        3 / 5 = 0 -> 1
        10 / 3 = 3 -> remain 1
        7/3 = 2 remain 1 
        */
        ListNode[] res = new ListNode[k];
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        
        int partSize = 0;
        int remain = 0;
        if (size <= k) {
            partSize = 1;
        } else {
            partSize = size / k;
            remain = size % k;
        }
        
        int count = 0;
        res[0] = head;
        int pos = 1;
        while (head != null) {
            count++;
            if (count == partSize) {
                if (remain > 0) {
                    head = head.next;
                    remain--;
                }
                count = 0;
                if (pos == k)
                    break;
                res[pos] = head.next;
                head.next = null;
            }
            if (count == 0) {
                head = res[pos];
                pos++;
                if (pos == k)
                    break;
            } else {
                head = head.next;
            }
            
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(k)
    */
}