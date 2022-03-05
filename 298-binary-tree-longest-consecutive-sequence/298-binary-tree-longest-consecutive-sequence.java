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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        dfs(root, root.val + 1, 1);
        return max;
    }
    
    void dfs(TreeNode root, int cur, int length) {
        if (root == null)
            return;
        if (root.val == cur) {
            max = Math.max(max, length + 1);
            dfs(root.left, cur + 1, length + 1);
            dfs(root.right, cur + 1, length + 1);
        } else {
            dfs(root.left, root.val + 1, 1);
            dfs(root.right, root.val + 1, 1);
        }
    }
}