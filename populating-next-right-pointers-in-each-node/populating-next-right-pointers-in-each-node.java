/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node first = queue.poll();
            if(first.left != null) {
                queue.offer(first.left);
                queue.offer(first.right);
                for(int i = 1; i < size; i++) {
                    Node n = queue.poll();
                    first.next = n;
                    first = n;
                    queue.offer(n.left);
                    queue.offer(n.right);
                    if(i == size-1) {
                        first = null;
                        n.next = null;
                    }
                }
            } else {
                for(int i = 1; i < size; i++) {
                    Node n = queue.poll();
                    first.next = n;
                    first = n;
                    if(i == size-1) {
                        first = null;
                        n.next = null;
                    }
                }
            }
        }
        return root;
    }
}