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
    int res = -1;
    public int closestValue(TreeNode root, double target) {
        if (res == -1)
            res = root.val;
        if (root == null)
            return res;
        if (Math.abs((double) root.val - target) < Math.abs((double) res - target))
            res = root.val;
        if ((double)root.val == target) {
            return root.val;
        } else if ((double)root.val > target) {
            return closestValue(root.left, target);
        } else return closestValue(root.right, target);
    }
}