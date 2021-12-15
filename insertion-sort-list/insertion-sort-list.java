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
    public ListNode insertionSortList(ListNode head) {
        /*
        loop throught 
        if it < pre num - > swap
        
        4 2 1 3
        l r
        2 4 1 3
        l r
        1-> l r -> 3  
        //not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
        
        */
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode left = dummy;
        ListNode nextNode = null;
        while (cur != null) {
            nextNode = cur.next;
            while (left.next != null && left.next.val < cur.val) {
                left = left.next;
            }
            
            cur.next = left.next;
            left.next = cur;
            left = dummy;
            cur = nextNode;
        }
        return dummy.next;
    }
}