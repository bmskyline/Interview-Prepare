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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        Result s = bst(root);
        return max;
    }
    
    Result bst(TreeNode root) {
        if (root == null)
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);;
        Result countLeft = bst(root.left);
        Result countRight = bst(root.right);
        if (countLeft.size == -1 || countRight.size == -1 || root.val <= countLeft.upper || root.val >= countRight.lower)
            return new Result(-1, 0, 0);
        int num = countLeft.size + countRight.size + 1;
        max = Math.max(max, num);
        return new Result(num, Math.min(countLeft.lower, root.val), Math.max(countRight.upper, root.val));
    }
}

 class Result {
        int size;
        int lower;
        int upper;
        
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }