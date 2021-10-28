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

    Random rand;
    ListNode head;
    int size = 0;;
    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
        while (head != null) {
            size++;
            head = head.next;
        }
    }
    
    public int getRandom() {
        int num = rand.nextInt(size);
        ListNode cur = head;
        for (int i = 0; i < num; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /*
    Time complexity : 
    - constructor : O(n)
    - getRandom : O(n)
    Space complexity : O(1)
    */
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */