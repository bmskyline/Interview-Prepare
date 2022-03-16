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
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null)
            return res;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap();
        Deque<TreeNode> nodes = new ArrayDeque();
        Deque<Integer> pos = new ArrayDeque();
        nodes.offer(root);
        pos.offer(0);
        while (!pos.isEmpty()) {
            int size = pos.size();
            Map<Integer, List<Integer>> curMap = new HashMap();
            for (int i = 0; i < size;i ++) {
                TreeNode cur = nodes.poll();
                int curPos = pos.poll();
                max = Math.max(max, curPos);
                min = Math.min(min, curPos);
                List<Integer> list = curMap.getOrDefault(curPos, new ArrayList());
                list.add(cur.val);
                curMap.put(curPos, list);
                if (cur.left != null) {
                    nodes.offer(cur.left);
                    pos.offer(curPos - 1);
                }
                if (cur.right != null) {
                    nodes.offer(cur.right);
                    pos.offer(curPos + 1);
                }
            }
            for (Map.Entry<Integer, List<Integer>> e : curMap.entrySet()) {
                int p = e.getKey();
                List<Integer> l = e.getValue();
                Collections.sort(l);
                List<Integer> temp = map.getOrDefault(p, new ArrayList());
                temp.addAll(l);
                map.put(p, temp);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}