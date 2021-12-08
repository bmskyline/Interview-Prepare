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
    int sum = 0;
    public int findTilt(TreeNode root) {
        sumValue(root);
        return sum;
    }
    
    public int sumValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumValue(root.left);
        int right = sumValue(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(logn)
    */
}