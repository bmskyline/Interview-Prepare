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
            Node parent = node.parent;
            while (parent != null &&  parent.val < node.val)
                parent = parent.parent;
            return parent;
        } else {
            Node right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
            
    }
}