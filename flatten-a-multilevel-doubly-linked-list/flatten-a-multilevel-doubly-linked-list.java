/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        Stack<Node> stack = new Stack<>();
        Node curNode = head;


        while(curNode != null){

            if(curNode.child != null){
                // if the current node has a child, then add the next node to the stack
                if(curNode.next != null)
                    stack.push(curNode.next);
                // point the next node to the child
                curNode.next = curNode.child;
                // remove the child's pointer
                curNode.child = null;
            }

            Node next = (curNode.next == null && !stack.isEmpty()) ? stack.pop() : curNode.next;

            if(next != null){
                // make sure all the pointers are correct
                next.prev = curNode;   
                curNode.next = next;
            }

            curNode = next;
        }
        return head;
    }
}