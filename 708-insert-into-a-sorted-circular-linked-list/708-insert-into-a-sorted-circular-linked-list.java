/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            insert.next = insert;
            return insert;
        }
        Node pos = head;
        while (pos.next != head) {
            if (pos.val <= insertVal && pos.next.val >= insertVal) {
                insert.next = pos.next; 
                pos.next = insert;
                return head;
            }
            if (pos.val > pos.next.val && pos.val <= insertVal && pos.next.val <= insertVal) {
                insert.next = pos.next; 
                pos.next = insert;
                return head;
            }
            if (pos.val > pos.next.val && pos.val > insertVal && pos.next.val > insertVal) {
                insert.next = pos.next; 
                pos.next = insert;
                return head;
            }
            pos = pos.next;
        }
        //System.out.println(pos.val +"  "+largest.val);
        insert.next = pos.next; 
        pos.next = insert;
        
        return head;
    }
}