/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        node = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        return buildTree(n);
    }
    
    TreeNode buildTree(int n) {
        if (n == 0)
            return null;
        TreeNode left = buildTree(n/2);
        //head = head.next;
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        root.right = buildTree(n - n/2 - 1);
        return root;
    }
}