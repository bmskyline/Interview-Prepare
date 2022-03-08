/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node.right == null) {
            while (node.parent != null && node.parent.right == node)
                node = node.parent;
            return node.parent;
        } else {
            Node right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
            
    }
}