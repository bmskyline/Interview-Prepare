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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null)
            return null;
        if (original == target) {
            return cloned;
        } else {
            TreeNode res = null;
            res = getTargetCopy(original.left, cloned.left, target);
            if (res != null)
                return res;
            return getTargetCopy(original.right, cloned.right, target);
        }
    }
}