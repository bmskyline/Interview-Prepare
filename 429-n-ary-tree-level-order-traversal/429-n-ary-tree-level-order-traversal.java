/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null)
            return res;
        Queue<Node> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lever = new ArrayList();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                lever.add(n.val);
                for (Node child : n.children) {
                    q.offer(child);
                }
            }
            res.add(lever);
        }
        return res;
    }
}