/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    public int diameter(Node root) {
        cal(root);
        return max;
    }
    
    int cal(Node root) {
        if (root == null)
            return 0;
        int first = 0;
        int second = 0;
        for (Node n : root.children) {
            int d = cal(n);
            if (d >= first) {
                second = first;
                first = d;
            } else if (d > second) {
                second = d;
            }
        }
        max = Math.max(first + second, max);
        return Math.max(first, second) + 1;
    }
}