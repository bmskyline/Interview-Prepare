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
    int pos = 0;
    public TreeNode str2tree(String s) {
        return buildTree(s);
    }
    
    TreeNode buildTree(String s) {
        if (pos == s.length())
            return null;
        if (s.charAt(pos) == ')') {
            pos++;
            return null; 
        }
        StringBuilder num = new StringBuilder();
        while (pos < s.length() && (Character.isDigit(s.charAt(pos)) || s.charAt(pos) =='-')) {
            num.append(s.charAt(pos));
            pos++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(num.toString()));
        if (pos < s.length() && s.charAt(pos) == '(') {
            pos++;
            root.left = buildTree(s);
        }
        if (pos < s.length() && s.charAt(pos) == '(') {
            pos++;
            root.right = buildTree(s);
        }
        pos++;
        return root;
    }
}