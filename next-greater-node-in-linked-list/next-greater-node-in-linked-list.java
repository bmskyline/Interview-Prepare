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
    int size = 0;
    public int[] nextLargerNodes(ListNode head) {
        /*
        then use stack
        5 5 0
        5
        */
        head = reverse(head);
        int[] res = new int[size];
        size -= 1;
        ArrayDeque<Integer> stack = new ArrayDeque();
        while (head != null && size >= 0) {
            while (!stack.isEmpty()) {
                if (stack.peek() > head.val) {
                    res[size--] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty())
                res[size--] = 0;
            stack.push(head.val);
            head = head.next;
        }
        return res;
    }
    
    ListNode reverse(ListNode head) {
        size++;
        if (head == null || head.next == null)
            return head;
        
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}