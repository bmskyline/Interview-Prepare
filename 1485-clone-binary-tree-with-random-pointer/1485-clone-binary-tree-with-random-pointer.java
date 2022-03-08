/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    Map<Node, NodeCopy> map = new HashMap();
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null)
            return null;
        cop(root);
        random(root);
        return map.get(root);
    }
    
    void random(Node root) {
        if (root == null)
            return;
        NodeCopy copy = map.get(root);
        copy.random = map.get(root.random);
        copy.left = map.get(root.left);
        copy.right = map.get(root.right);
        random(root.left);
        random(root.right);
    }
    
    public void cop(Node root) {
        if (root == null)
            return;
        NodeCopy copy = new NodeCopy(root.val);
        map.put(root, copy);
        cop(root.left);
        cop(root.right);
    }
}