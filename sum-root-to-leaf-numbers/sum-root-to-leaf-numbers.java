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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        sum(root, 0);
        return res;
    }
    
    public void sum(TreeNode root, int cur) {
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += cur;
            return;
        }
        if (root.left != null) {
            sum(root.left, cur);
        }
        if (root.right != null) {
            sum(root.right, cur);
        }
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}