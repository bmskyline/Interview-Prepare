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
        NodeCopy res = cop(root);
        random(root);
        return res;
    }
    
    void random(Node root) {
        if (root == null)
            return;
        NodeCopy copy = map.get(root);
        copy.random = map.get(root.random);
        random(root.left);
        random(root.right);
    }
    
    public NodeCopy cop(Node root) {
        if (root == null)
            return null;
        NodeCopy copy = map.getOrDefault(root, new NodeCopy(root.val));
        map.put(root, copy);
        copy.left = cop(root.left);
        copy.right = cop(root.right);
        return copy;
    }
}