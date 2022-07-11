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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer last = null;
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
                last = n.val;
            }
            if (last != null)
                res.add(last);
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space comlexity : O(height)
    */
}