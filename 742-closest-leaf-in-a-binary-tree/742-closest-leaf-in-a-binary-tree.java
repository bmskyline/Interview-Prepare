/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> g = new HashMap();
        TreeNode node = buildGraph(root, g, null, k);
        TreeNode res = bfs(g, node);
        return res == null ? root.val : res.val; 
    }
    
    TreeNode bfs(Map<TreeNode, List<TreeNode>> graph, TreeNode k) {
        Deque<TreeNode> queue = new ArrayDeque();
        queue.offer(k);
        Set<Integer> visited = new HashSet();
        visited.add(k.val);
        int dis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null)
                    return cur;
                for (TreeNode next : graph.get(cur)) {
                    if (!visited.contains(next.val)) {
                        queue.offer(next);
                        visited.add(next.val);
                    }
                }
            }
            dis++;
        }
        return null;
    }
    
    TreeNode buildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> graph, TreeNode parent, int k){
        if (root == null)
            return null;
        List<TreeNode> list = graph.getOrDefault(root, new ArrayList());
        TreeNode l = null, r = null;
        if (parent != null) {
            list.add(parent);
        }
        if (root.left != null) {
            list.add(root.left);
            l = buildGraph(root.left, graph, root, k);
        }
        if (root.right != null) {
            list.add(root.right);
            r = buildGraph(root.right, graph, root, k);
        }
        graph.put(root, list);
        if (root.val == k)
            l = root;
        return l != null ? l : r;
    }
}