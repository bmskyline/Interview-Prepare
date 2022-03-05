/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowest(root, p, q);
        return res;
    }
    
    public TreeNode lowest(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode left = lowest(root.left, p, q);
        TreeNode right = lowest(root.right, p, q);
        if (left != null && right != null && res == null)
            res = root;
        if (root == p) {
            if (left == q || right == q)
                if (res == null)
                    res = root;
            return root;
        } else if (root == q) {
            if (left == p || right == p)
                if (res == null)
                    res = root;
            return root;
        }
        return left != null ? left : right;
    }
}