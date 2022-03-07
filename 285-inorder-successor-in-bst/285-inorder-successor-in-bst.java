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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return findNextNode(root, new Stack(), p);
    }
    
    TreeNode findNextNode(TreeNode root, Stack<TreeNode> stack, TreeNode p) {
        if (root == null)
            return null;
        if (root.val == p.val) {
            if (root.right == null) {
                while(!stack.isEmpty() && stack.peek().val < root.val)
                    stack.pop();
                if (stack.isEmpty())
                    return null;
                return stack.pop();
            } else {
                TreeNode right = root.right;
                while (right.left != null) {
                    right = right.left;
                }
                return right;
            }
        } else if (p.val < root.val) {
            stack.push(root);
            return findNextNode(root.left, stack, p);
        } else {
            stack.push(root);
            return findNextNode(root.right, stack, p);
        }
    }
}