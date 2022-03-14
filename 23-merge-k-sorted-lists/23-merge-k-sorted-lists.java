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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            while (node != null) {
                q.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!q.isEmpty()) {
            cur.next = q.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}