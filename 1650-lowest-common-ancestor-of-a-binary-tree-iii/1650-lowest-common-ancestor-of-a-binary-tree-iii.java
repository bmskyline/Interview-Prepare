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
    public Node lowestCommonAncestor(Node p, Node q) {
        int dP = findDepth(p);
        int dQ = findDepth(q);
        while (dP > dQ) {
            p = p.parent;
            dP--;
        }
        while (dQ > dP) {
            q = q.parent;
            dQ--;
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
    
    int findDepth(Node p) {
        int depth = 0;
        while (p.parent != null) {
            p = p.parent;
            depth++;
        }
        return depth;
    }
}