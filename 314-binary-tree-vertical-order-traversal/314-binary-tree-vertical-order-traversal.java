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
    /*
    3 -> 0 
    9 -> -1
    
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList();
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        ArrayDeque<Integer> cQueue = new ArrayDeque();
        queue.add(root);
        cQueue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode node = queue.poll();
                Integer col = cQueue.poll();
                List<Integer> list = map.getOrDefault(col, new ArrayList());
                list.add(node.val);
                map.put(col, list);
                if (node.left != null) {
                    queue.offer(node.left);
                    cQueue.offer(col - 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    cQueue.offer(col + 1);
                }
            }
        }
        List<List<Integer>> res = new ArrayList();
        for (Integer key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    
    /*
    Time complexity : O(nlogn)
    Space complexity : O(n)
    */
}