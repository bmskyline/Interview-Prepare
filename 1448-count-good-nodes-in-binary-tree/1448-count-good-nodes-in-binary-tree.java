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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    int dfs(TreeNode root, int max) {
        int count = 0;
        if (root == null)
            return count;
        if (root.val >= max)
            count++;
        count += dfs(root.left, Math.max(max, root.val));
        count += dfs(root.right, Math.max(max, root.val));
        return count;
    }
    
}