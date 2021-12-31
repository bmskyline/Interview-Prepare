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
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(maxDiff(root.left, root.val, root.val), maxDiff(root.right, root.val, root.val));
    }
    
    int maxDiff(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        if (root.val < min) {
            min = root.val;
        } else if (root.val > max) {
            max = root.val;
        }
        return Math.max(maxDiff(root.left, min, max), maxDiff(root.right, min, max));
    }
}