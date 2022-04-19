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
    TreeNode wr1 = null;
    TreeNode wr2 = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        swap(wr1, wr2);
    }
    
    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (pre != null && wr1 == null && pre.val >= root.val) {
            wr1 = pre;
        }
        if (wr1 != null && pre.val >= root.val) {
            wr2 = root;
        }
        pre = root;
        traverse(root.right);
    }

    public void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}